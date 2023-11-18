/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    // private Employee getemp(List<Emplu)
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map=new HashMap<>();
        for(Employee e:employees){
            map.put(e.id, e);
        }
        Queue<Employee>q=new LinkedList<>();
        q.add(map.get(id));
        int ans=map.get(id).importance;
        while(!q.isEmpty()){
            Employee e=q.poll();
            for(int v:e.subordinates){
                q.add(map.get(v));
                ans+=map.get(v).importance;
                
            }
        }
        return ans;

        
        
    }
}