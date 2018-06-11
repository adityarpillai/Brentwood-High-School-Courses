public class PillaiDataTypes {

    public static void main(String[] args) {
        System.out.println("Aditya Pillai \t 08/17/2016\n");
        int hoursWorked;
        double hourlyWage;
        double overTimeWage;
        boolean overTime;
        int overTimeHours;
        double totalWage;
        double federalTaxReduction;
        double fourOhOneK;
        double netPay;

        //Employee 1
        hoursWorked = 40;
        hourlyWage = 21.25;
        overTimeHours = 0;
        overTimeWage = hourlyWage * 1.5;
        overTime = false;
        //noinspection ConstantConditions
        if (hoursWorked > 40) {
            overTime = true;
            overTimeHours = hoursWorked - 40;
        }
        totalWage = hourlyWage * (hoursWorked - overTimeHours) + overTimeWage * overTimeHours;
        federalTaxReduction = 0.27 * totalWage;
        fourOhOneK = 0.12 * totalWage;
        netPay = totalWage - federalTaxReduction - fourOhOneK;
        System.out.println("Employee 1:");
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.printf("Total Wages: $%.2f", totalWage);
        System.out.printf("\nFederal Tax Reduction: $%.2f", federalTaxReduction);
        System.out.printf("\n401k Withholding: $%.2f", fourOhOneK);
        System.out.printf("\nNet Pay: $%.2f", netPay);
        //noinspection ConstantConditions
        System.out.println("\nOvertime: " + overTime);

        //Employee 2
        hoursWorked = 43;
        hourlyWage = 24.50;
        overTimeHours = 0;
        overTimeWage = hourlyWage * 1.5;
        overTime = false;
        //noinspection ConstantConditions
        if (hoursWorked > 40) {
            overTime = true;
            overTimeHours = hoursWorked - 40;
        }
        totalWage = hourlyWage * (hoursWorked - overTimeHours) + overTimeWage * overTimeHours;
        federalTaxReduction = 0.27 * totalWage;
        fourOhOneK = 0.12 * totalWage;
        netPay = totalWage - federalTaxReduction - fourOhOneK;
        System.out.println("\nEmployee 2:");
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.printf("Total Wages: $%.2f", totalWage);
        System.out.printf("\nFederal Tax Reduction: $%.2f", federalTaxReduction);
        System.out.printf("\n401k Withholding: $%.2f", fourOhOneK);
        System.out.printf("\nNet Pay: $%.2f", netPay);
        //noinspection ConstantConditions
        System.out.println("\nOvertime: " + overTime);

        //Employee 3
        hoursWorked = 35;
        hourlyWage = 18.00;
        overTimeHours = 0;
        overTimeWage = hourlyWage * 1.5;
        overTime = false;
        //noinspection ConstantConditions
        if (hoursWorked > 40) {
            overTime = true;
            overTimeHours = hoursWorked - 40;
        }
        totalWage = hourlyWage * (hoursWorked - overTimeHours) + overTimeWage * overTimeHours;
        federalTaxReduction = 0.27 * totalWage;
        fourOhOneK = 0;
        netPay = totalWage - federalTaxReduction - fourOhOneK;
        System.out.println("\nEmployee 3:");
        System.out.println("Hours Worked: " + hoursWorked);
        System.out.printf("Total Wages: $%.2f", totalWage);
        System.out.printf("\nFederal Tax Reduction: $%.2f", federalTaxReduction);
        System.out.printf("\n401k Withholding: $%.2f", fourOhOneK);
        System.out.printf("\nNet Pay: $%.2f", netPay);
        //noinspection ConstantConditions
        System.out.println("\nOvertime: " + overTime);
    }

}
