package model;

public class Category {
    private int category_id;
    private Department department;
    private String category_name;

    public Category(int category_id, Department department, String category_name) {
        this.category_id = category_id;
        this.department = department;
        this.category_name = category_name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Category{category_id=").append(category_id);
        sb.append(", department=").append(department);
        sb.append(", category_name=").append(category_name);
        sb.append('}');
        return sb.toString();
    }
    
    
}
