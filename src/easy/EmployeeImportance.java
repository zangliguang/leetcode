package easy;

import java.util.*;

public class EmployeeImportance {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        List<Integer> subordinates = new ArrayList<>();
        List<Integer> subordinates2 = new ArrayList<>();
        subordinates2.add(4);
        subordinates.add(2);
        subordinates.add(3);
        employees.add(new Employee(1, 5, subordinates));
        employees.add(new Employee(2, 3, subordinates2));
        employees.add(new Employee(3, 4, new ArrayList<>()));
        employees.add(new Employee(4, 1, new ArrayList<>()));
        getImportance(employees, 1);
    }

    public static int getImportance(List<Employee> employees, int id) {
        int result = 0;
        HashMap<Integer, Employee> map = new HashMap();
        List<Integer> list = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.id == id) {
                result += employee.importance;
                if (employee.subordinates.size() == 0) {
                    return result;
                }
                list = employee.subordinates;
            }
            map.put(employee.id, employee);
        }
        return  getSubResult(result, map, list);
    }

    private static int getSubResult(int result, HashMap<Integer, Employee> map, List<Integer> list) {


        List<Integer> sublist=new ArrayList<>();
        for (Integer subid : list) {
            Employee subEm = map.get(subid);
            result += subEm.importance;
            sublist.addAll(subEm.subordinates);
        }
        System.out.println("result="+result);
        System.out.println("find="+sublist.toString());
        if(sublist.size()>0){
            return getSubResult(result,map,sublist);
        }
        System.out.println("final result="+result);
        return result;
    }


    static class Employee {
        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }

        public int id;
        public int importance;
        public List<Integer> subordinates;


        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", importance=" + importance +
                    ", subordinates=" + subordinates +
                    '}';
        }
    }
}
