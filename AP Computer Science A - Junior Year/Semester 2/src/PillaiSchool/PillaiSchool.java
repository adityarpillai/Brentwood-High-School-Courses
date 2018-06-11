package PillaiSchool;

import java.util.ArrayList;

/**
 * Created by adityapillai on 2/1/17.
 * PillaiSchool object
 */
class PillaiSchool {

    private ArrayList<Counselor> counselors = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();
    private Principal principal;

    PillaiSchool(Principal principal) {
        this.principal = principal;
    }

    Counselor getCounselors(int index) {
        return counselors.get(index);
    }

    Teacher getTeachers(int index) {
        return teachers.get(index);
    }

    Principal getPrincipal() {
        return principal;
    }

    void addCounselor(Counselor counselor) {
        counselors.add(counselor);
    }

    void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
}
