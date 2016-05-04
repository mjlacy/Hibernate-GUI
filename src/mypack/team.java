/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypack;

import javax.persistence.*;

/**
 *
 * @author Michael 
 */

@Entity
@Table(name = "EVALUATIONS")
public class team {
   @Id
   @Column(name = "TEAMNAME")
    private String teamName;
   
   @Column(name = "Q1")
    private int q1;
    
    @Column(name = "Q2")
    private int q2;
    
    @Column(name = "Q3")
    private int q3;
    
    @Column(name = "Q4")
    private int q4;
    
    @Column(name = "AVGSCORE")
    private double avgScore;
    
    @Column(name = "COMMENTS")
    private String comments;

    /**
     * @return the teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * @param teamName the teamName to set
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * @return the q1
     */
    public int getQ1() {
        return q1;
    }

    /**
     * @param q1 the q1 to set
     */
    public void setQ1(int q1) {
        this.q1 = q1;
    }

    /**
     * @return the q2
     */
    public int getQ2() {
        return q2;
    }

    /**
     * @param q2 the q2 to set
     */
    public void setQ2(int q2) {
        this.q2 = q2;
    }

    /**
     * @return the q3
     */
    public int getQ3() {
        return q3;
    }

    /**
     * @param q3 the q3 to set
     */
    public void setQ3(int q3) {
        this.q3 = q3;
    }

    /**
     * @return the q4
     */
    public int getQ4() {
        return q4;
    }

    /**
     * @param q4 the q4 to set
     */
    public void setQ4(int q4) {
        this.q4 = q4;
    }

    /**
     * @return the avgScore
     */
    public double getAvgScore() {
        return avgScore;
    }

    /**
     * @param avgScore the avgScore to set
     */
    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    /**
     * @return the comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(String comments) {
        this.comments = comments;
    }   
}