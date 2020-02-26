
package com.senosy.soccer.Entity.MatchEntities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class Match {

    @SerializedName("competition_id")
    @Expose
    private int competitionId;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("ht_score")
    @Expose
    private String htScore;
    @SerializedName("ft_score")
    @Expose
    private String ftScore;
    @SerializedName("et_score")
    @Expose
    private String etScore;
    @SerializedName("last_changed")
    @Expose
    private String lastChanged;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("league_name")
    @Expose
    private String leagueName;
    @SerializedName("away_id")
    @Expose
    private int awayId;
    @SerializedName("score")
    @Expose
    private String score;
    @SerializedName("competition_name")
    @Expose
    private String competitionName;
    @SerializedName("events")
    @Expose
    private String events;
    @SerializedName("home_id")
    @Expose
    private int homeId;
    @SerializedName("away_name")
    @Expose
    private String awayName;
    @SerializedName("added")
    @Expose
    private String added;
    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("home_name")
    @Expose
    private String homeName;
    @SerializedName("league_id")
    @Expose
    private int leagueId;
    @SerializedName("location")
    @Expose
    private String location;
    @SerializedName("fixture_id")
    @Expose
    private int fixtureId;
    @SerializedName("scheduled")
    @Expose
    private String scheduled;

    public int getCompetitionId() {
        return competitionId;
    }

    public void setCompetitionId(int competitionId) {
        this.competitionId = competitionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getHtScore() {
        return htScore;
    }

    public void setHtScore(String htScore) {
        this.htScore = htScore;
    }

    public String getFtScore() {
        return ftScore;
    }

    public void setFtScore(String ftScore) {
        this.ftScore = ftScore;
    }

    public String getEtScore() {
        return etScore;
    }

    public void setEtScore(String etScore) {
        this.etScore = etScore;
    }

    public String getLastChanged() {
        return lastChanged;
    }

    public void setLastChanged(String lastChanged) {
        this.lastChanged = lastChanged;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLeagueName() {
        return leagueName;
    }

    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    public int getAwayId() {
        return awayId;
    }

    public void setAwayId(int awayId) {
        this.awayId = awayId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getCompetitionName() {
        return competitionName;
    }

    public void setCompetitionName(String competitionName) {
        this.competitionName = competitionName;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }

    public int getHomeId() {
        return homeId;
    }

    public void setHomeId(int homeId) {
        this.homeId = homeId;
    }

    public String getAwayName() {
        return awayName;
    }

    public void setAwayName(String awayName) {
        this.awayName = awayName;
    }

    public String getAdded() {
        return added;
    }

    public void setAdded(String added) {
        this.added = added;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public int getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(int leagueId) {
        this.leagueId = leagueId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getFixtureId() {
        return fixtureId;
    }

    public void setFixtureId(int fixtureId) {
        this.fixtureId = fixtureId;
    }

    public String getScheduled() {
        return scheduled;
    }

    public void setScheduled(String scheduled) {
        this.scheduled = scheduled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return competitionId == match.competitionId &&
                id == match.id &&
                awayId == match.awayId &&
                homeId == match.homeId &&
                leagueId == match.leagueId &&
                fixtureId == match.fixtureId &&
                Objects.equals(status, match.status) &&
                Objects.equals(htScore, match.htScore) &&
                Objects.equals(ftScore, match.ftScore) &&
                Objects.equals(etScore, match.etScore) &&
                Objects.equals(lastChanged, match.lastChanged) &&
                Objects.equals(leagueName, match.leagueName) &&
                Objects.equals(score, match.score) &&
                Objects.equals(competitionName, match.competitionName) &&
                Objects.equals(events, match.events) &&
                Objects.equals(awayName, match.awayName) &&
                Objects.equals(added, match.added) &&
                Objects.equals(time, match.time) &&
                Objects.equals(homeName, match.homeName) &&
                Objects.equals(location, match.location) &&
                Objects.equals(scheduled, match.scheduled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(competitionId, status, htScore, ftScore, etScore, lastChanged, id, leagueName, awayId, score, competitionName, events, homeId, awayName, added, time, homeName, leagueId, location, fixtureId, scheduled);
    }
}
