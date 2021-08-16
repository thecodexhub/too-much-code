#include <iostream>
using std::string;

// Abstraction
class AbstractEmployee
{
    virtual void AskForPromotion() = 0; // Pure virtual function
};

class Employee : AbstractEmployee
{
private:
    string Company;
    int Age;

protected:
    string Name;

public:
    // Encapsulation
    void setName(string name) { Name = name; }
    string getName() { return Name; }

    void setCompany(string company) { Company = company; }
    string getCompany() { return Company; }

    void setAge(int age)
    {
        if (age >= 18)
            Age = age;
    }
    int getAge() { return Age; }

    void IntroduceYourself()
    {
        std::cout << "Name - " << Name << std::endl;
        std::cout << "Company - " << Company << std::endl;
        std::cout << "Age - " << Age << std::endl;
    }

    Employee(string name, string company, int age)
    {
        Name = name;
        Company = company;
        Age = age;
    }
    void AskForPromotion()
    {
        if (Age > 30)
            std::cout << Name << " got promoted!" << std::endl;
        else
            std::cout << Name << ", sorry no promotion for you :(" << std::endl;
    }
    virtual void Work()
    {
        std::cout << Name << " is checking emails, task backlogs and performing tasks..." << std::endl;
    }
};

// Inheritance
class Developer : public Employee
{
private:
    string FavProgrammingLanguage;

public:
    void setFavProgrammingLanguage(string favProgrammingLanguage) { FavProgrammingLanguage = favProgrammingLanguage; }
    string getFavProgrammingLanguage() { return FavProgrammingLanguage; }

    Developer(string name, string company, int age, string favProgrammingLanguage)
        : Employee(name, company, age)
    {
        FavProgrammingLanguage = favProgrammingLanguage;
    }
    void FixBug()
    {
        std::cout << Name << " fixed bug using " << FavProgrammingLanguage << std::endl;
    }
    void Work()
    {
        std::cout << Name << " is writing " << FavProgrammingLanguage << " code and fixing bugs..." << std::endl;
    }
};

class Teacher : public Employee
{
private:
    string Subject;

public:
    void setSubject(string subject) { Subject = subject; }
    string getSubject() { return Subject; }
    void PrepareLesson()
    {
        std::cout << Name << " is preparing " << Subject << " lesson." << std::endl;
    }
    Teacher(string name, string company, int age, string subject) : Employee(name, company, age)
    {
        Subject = subject;
    }
    void Work()
    {
        std::cout << Name << " is teaching " << Subject << "." << std::endl;
    }
};

int main()
{
    Employee employee1 = Employee("Sandip", "IG-thecodexhub", 21);
    employee1.IntroduceYourself();

    Employee employee2 = Employee("John", "Google", 32);
    employee2.IntroduceYourself();

    employee2.setAge(15);
    std::cout << employee2.getName() << " is " << employee2.getAge() << " years old." << std::endl;
    employee1.AskForPromotion();
    employee2.AskForPromotion();

    Developer developer = Developer("Sandip", "IG-thecodexhub", 21, "C++");
    developer.FixBug();
    developer.AskForPromotion();

    Teacher teacher = Teacher("Jack", "Cool School", 35, "Power System");
    teacher.PrepareLesson();
    teacher.AskForPromotion();

    developer.Work();
    teacher.Work();

    Employee *e1 = &developer;
    Employee *e2 = &teacher;

    e1->Work();
    e2->Work();

    // *The most common use of polymorphism is when a parent class reference
    // *is used to refer to a child class object.
}
