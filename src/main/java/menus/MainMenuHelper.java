package menus;

import entities.*;
import util.SingletonEntityManager;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MainMenuHelper {
    EntityManager em = SingletonEntityManager.getEntityManager();
    public void showMostPayedCoach() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery();
        Root<CoachSeason> root = cq.from(CoachSeason.class);

        Subquery<Long> subquery = cq.subquery(Long.class);
        Root<CoachSeason> subRoot = subquery.from(CoachSeason.class);

        subquery.select(cb.max(subRoot.get("salary")));
        cq.select(root).where(cb.equal(root.get("salary"),subquery));
        Query q=  em.createQuery(cq);
        Object obj = q.getResultList();

        System.out.println(obj);
    }

    public void showMostPayedPlayersPerSeason() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<PlayerSeason> query = cb.createQuery(PlayerSeason.class);
        Root<PlayerSeason> root = query.from(PlayerSeason.class);

        Subquery<Long> subquery = query.subquery(Long.class);
        Root<PlayerSeason> subRoot = subquery.from(PlayerSeason.class);

        subquery.select(cb.max(subRoot.get("salary"))).where(cb.equal(  subRoot.get("season") , root.get("season")  ));
        query.select(root).where(cb.equal( root.get("salary") , subquery )).groupBy(root.get("season"));

        em.createQuery(query).getResultList().forEach(System.out::println);
    }

    public void showCityAndTeams() {
        em.getTransaction().begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
        Root<Team> root = query.from(Team.class);

        Join<Object, Object> city = root.join("city");

        query.multiselect(city , cb.count(root)).groupBy(city);
        em.createQuery(query).getResultList().forEach(e->System.out.println(((City)e[0]).getName() + " " + e[1]));
    }

    public Map<Team, Long> showTeamPoints(int year) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = cb.createQuery(Object[].class);
        Map<Team, Long> hostPoints = getHostPoints(query, cb, em , year);
        query = cb.createQuery(Object[].class);
        Map<Team, Long> guestPoints = getGuestPoints(query, cb, em,year);
        Map<Team, Long> mergedMap = mergeResults(hostPoints, guestPoints);
        System.out.println(mergedMap);
        return mergedMap;
    }

    private Map<Team, Long> getHostPoints(CriteriaQuery<Object[]> query , CriteriaBuilder cb , EntityManager em , int year) {
        Root<Matche> from = query.from(Matche.class);

        Subquery<Integer> subquery = query.subquery(Integer.class);
        Root<Matche> root = subquery.from(Matche.class);
        subquery.select( cb.sum(root.get("hostPoints")) ).where(cb.and(cb.equal(root.get("hostTeam"),from.get("hostTeam")), cb.equal(root.get("season").get("year"),cb.parameter(Integer.class , "year"))) );

        query.multiselect( from.get("hostTeam") , subquery).groupBy(from.get("hostTeam"));
        Map<Team, Long> results = new HashMap<>();
        em.createQuery(query).setParameter("year" , year).getResultList().forEach(s-> results.put((Team) s[0] , (Long) s[1] ));
        return results;
    }

    private Map<Team, Long> getGuestPoints(CriteriaQuery<Object[]> query , CriteriaBuilder cb , EntityManager em , int year) {
        Root<Matche> from = query.from(Matche.class);

        Subquery<Integer> subquery = query.subquery(Integer.class);
        Root<Matche> root = subquery.from(Matche.class);
        subquery.select( cb.sum(root.get("guestPoints")) ).where(cb.and(cb.equal(root.get("guestTeam"),from.get("guestTeam")), cb.equal(root.get("season").get("year"),cb.parameter(Integer.class , "year"))) );

        query.multiselect( from.get("guestTeam"), subquery).groupBy(from.get("guestTeam"));
        Map<Team, Long> results = new HashMap<>();
        em.createQuery(query).setParameter("year" , year).getResultList().forEach(s-> results.put((Team) s[0] , (Long) s[1] ));
        return results;
    }

    private Map<Team, Long> mergeResults(Map<Team, Long> first , Map<Team, Long> second){
        Map<Team, Long> results = new HashMap<>();
        first.entrySet().stream().forEach(entry -> {if( entry.getValue()!=null) results.put(entry.getKey() , entry.getValue()); } );
        second.entrySet().stream().forEach(entry -> {if( entry.getValue()!=null) results.put(entry.getKey() ,
                results.get(entry.getKey())==null? entry.getValue() : results.get(entry.getKey())+ entry.getValue() ); });
        return results;
    }

    public void showChampion(int year) {
        Map<Team, Long> fourth = showTeamPoints(year);
        System.out.println(fourth.entrySet().stream().max(Comparator.comparing(e-> e.getValue() ) ));
    }
}
