/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad4;


public class StreamLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Employees
        System.out.println("----- Employees test -----");
        Employee employee = new Employee();
        employee.printPersons();

        Employee.statistics();

        employee.personsStatsByGenderCount();
        employee.personsStatsByGenderList();


        // SummaryStatistics
        System.out.println("\n----- SummaryStatistics test -----");
        SummaryStatistics stats = new SummaryStatistics();
        stats.setup();

        stats.averageWithJava();
        stats.statsWithStreamReduce();
        stats.allStatsWithStream();

        stats.statsWithStreamAverage();
        stats.statsWithStreamMin();
        stats.statsWithStreamReduce();
       
        stats.setupCompanies();
        stats.companyStats();
        stats.companyStatsWithStreamAverage();
    }
}
