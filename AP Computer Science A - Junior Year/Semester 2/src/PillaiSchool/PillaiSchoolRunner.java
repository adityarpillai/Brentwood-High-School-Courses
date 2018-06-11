package PillaiSchool;

import javax.swing.*;

/**
 * Created by adityapillai on 2/1/17.
 *
 * Stuff for program.
 */
public class PillaiSchoolRunner {

    public static void main(String[] args) {
        String principalName = JOptionPane.showInputDialog(null, "Enter the name of the principal:");

        boolean check;
        int num = 0;
        do {
            check = true;
            try {
                num = Integer.parseInt(JOptionPane.showInputDialog("Enter the age of the principal."));
            } catch (NumberFormatException nfe) {
                check = false;
            }
        } while (!check);
        String gender = JOptionPane.showInputDialog(null, "Enter the gender of the principal:");


        PillaiSchool myPillaiSchool = new PillaiSchool(new Principal(principalName, num /* i don't know if that's an overestimate or underestimate*/, gender));

        for (int i = 0; i < 4; i++) {
            String teacherName = JOptionPane.showInputDialog(null, "Enter the name of the teacher " + (i + 1) + ":");
            do {
                check = true;
                try {
                    num = Integer.parseInt(JOptionPane.showInputDialog("Enter the age of the teacher."));
                } catch (NumberFormatException nfe) {
                    check = false;
                }
            } while (!check);
            gender = JOptionPane.showInputDialog("Enter the gender of " + teacherName + ":");
            String[] subjects = {"Math", "Language Arts", "Science", "History"};
            int subjectInt = JOptionPane.showOptionDialog(null, "Enter the subject of the teacher", "PillaiSchool.Teacher Subject", JOptionPane.YES_NO_CANCEL_OPTION
                    , JOptionPane.QUESTION_MESSAGE, null, subjects, subjects[0]);
            myPillaiSchool.addTeacher(new Teacher(teacherName, num, gender, subjectInt));
        }

        for (int i = 0; i < 2; i++) {
            String counselorName = JOptionPane.showInputDialog(null, "Enter the name of the counselor " + i + 1 + ":");
            do {
                check = true;
                try {
                    num = Integer.parseInt(JOptionPane.showInputDialog("Enter the age of the counselor:"));
                } catch (NumberFormatException nfe) {
                    check = false;
                }
            } while (!check);
            gender = JOptionPane.showInputDialog("Enter the gender of " + counselorName + ":");
            myPillaiSchool.addCounselor(new Counselor(counselorName, num, gender));
        }

        int repeat = 0;
        String[] messages = {"Open", "Exit"};
        //while repeat = a diff number other than 0, will go through program.
        while (repeat == 0) {
            repeat = JOptionPane.showOptionDialog(null, "Choose an option:", "Pillai PillaiSchool.PillaiSchool", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null
                    , messages, messages[0]);
            if (repeat == 0) {
                runProgram(myPillaiSchool);
            }
        }

    }

    private static void runProgram(PillaiSchool myPillaiSchool) {
        String[] messages = {"PillaiSchool.Principal", "Counselors", "Teachers"};
        int choice = JOptionPane.showOptionDialog(null, "Choose a department:", "Pillai PillaiSchool.PillaiSchool", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, messages, messages[0]);
        switch (choice) {
            case 0:
                runPrincipals(myPillaiSchool);
                break;
            case 1:
                runCounselors(myPillaiSchool);
                break;
            case 2:
                runTeachers(myPillaiSchool);
                break;
            default:
                break;
        }
    }

    private static void runTeachers(PillaiSchool myPillaiSchool) {
        String[] teacherNames = new String[4];
        Teacher[] teachers = new Teacher[4];
        for (int i = 0; i < 4; i++) {
            teacherNames[i] = myPillaiSchool.getTeachers(i).getName();
            teachers[i] = myPillaiSchool.getTeachers(i);
        }
        int choice = JOptionPane.showOptionDialog(null, "Choose a counselor:", "Pillai PillaiSchool.PillaiSchool Counselors", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, teacherNames, teacherNames[0]);
        switch (choice) {
            case 0:
                showTeacher(teachers[0]);
                break;
            case 1:
                showTeacher(teachers[1]);
                break;
            case 2:
                showTeacher(teachers[2]);
                break;
            case 3:
                showTeacher(teachers[3]);
                break;
            default:
                break;
        }

    }

    private static void showTeacher(Teacher teacher) {

        String[] messages = {"Name", "Age", "Gender", "Teach Lesson", "Describe Job"};
        int choice = JOptionPane.showOptionDialog(null, teacher.getName() + ":", "Pillai PillaiSchool.PillaiSchool PillaiSchool.Counselor", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, messages, messages[0]);
        switch (choice) {
            case 0:
                JOptionPane.showMessageDialog(null, "The teachers's name is " + teacher.getName());
                break;
            case 1:
                JOptionPane.showMessageDialog(null, teacher.getName() + " is " + teacher.getAge() + " years old.");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, teacher.getName() + " is " + teacher.getGender());
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Lesson from " + teacher.getName() + ":\n" + teacher.teachLesson());
                break;
            case 4:
                JOptionPane.showMessageDialog(null, teacher.getName() + " says, \"" + teacher.describeJob() + "\".");
                break;
            default:
                break;

        }
    }

    private static void runCounselors(PillaiSchool myPillaiSchool) {
        String[] counselorNames = new String[2];
        Counselor[] counselors = new Counselor[2];
        for (int i = 0; i < 2; i++) {
            counselorNames[i] = myPillaiSchool.getCounselors(i).getName();
            counselors[i] = myPillaiSchool.getCounselors(i);
        }
        int choice = JOptionPane.showOptionDialog(null, "Choose a counselor:", "Pillai PillaiSchool.PillaiSchool Counselors", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, counselorNames, counselorNames[0]);
        switch (choice) {
            case 0:
                showCounselor(counselors[0]);
                break;
            case 1:
                showCounselor(counselors[1]);
                break;
            default:
                break;
        }


    }

    private static void showCounselor(Counselor counselor) {
        String[] messages = {"Name", "Age", "Gender", "Get Advice", "Describe Job"};
        int choice = JOptionPane.showOptionDialog(null, counselor.getName() + ":", "Pillai PillaiSchool.PillaiSchool PillaiSchool.Counselor", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, messages, messages[0]);
        switch (choice) {
            case 0:
                JOptionPane.showMessageDialog(null, "The counselor's name is " + counselor.getName());
                break;
            case 1:
                JOptionPane.showMessageDialog(null, counselor.getName() + " is " + counselor.getAge() + " years old.");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, counselor.getName() + " is " + counselor.getGender());
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Advice from " + counselor.getName() + ":\n" + counselor.getAdvice());
                break;
            case 4:
                JOptionPane.showMessageDialog(null, counselor.getName() + " says, \"" + counselor.describeJob() + "\".");
                break;
            default:
                break;

        }
    }

    private static void runPrincipals(PillaiSchool myPillaiSchool) {
        Principal localPrincipal = myPillaiSchool.getPrincipal();
        String[] messages = {"Name", "Age", "Gender", "Make Announcement", "Describe Job"};
        int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Pillai PillaiSchool.PillaiSchool PillaiSchool.Principal", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, messages, messages[0]);
        switch (choice) {
            case 0:
                JOptionPane.showMessageDialog(null, "The principal's name is " + localPrincipal.getName());
                break;
            case 1:
                JOptionPane.showMessageDialog(null, localPrincipal.getName() + " is " + localPrincipal.getAge() + " years old.");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, localPrincipal.getName() + " is " + localPrincipal.getGender());
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "A message from " + localPrincipal.getName() + ":\n" + localPrincipal.makeAnnouncement());
                break;
            case 4:
                JOptionPane.showMessageDialog(null, localPrincipal.getName() + " says, \"" + localPrincipal.describeJob() + "\".");
                break;
            default:
                break;

        }
    }

}
