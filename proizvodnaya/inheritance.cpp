#include <iostream>
#include <vector>

class Derivative//базовый класс производна
{
public:
	Derivative(double x, double h) //конструктор
	{
		_x = x;
		_h = h;
		std::cout << "Base class: CONSTRUCTOR" << std::endl;
	}
	~Derivative()//деструктор
	{
		std::cout << "Base class: DESTRUCTOR" << std::endl;
	}
	double func(double a)
	{
		return a * a; //функция от которой ищем производную
	}
	virtual void calculate() = 0;

	double value() const
	{
		return _derivative;
	}

protected:
	double _derivative = 0;//производная
	double _x;//т-ка
	double _h;//шаг
};

class Left : public Derivative
{
public:
	Left(double x, double h) : Derivative(x, h)
	{
		//_derivative = derivative;
		std::cout << "Left class: CONSTRUCTOR" << std::endl;
	}
	~Left()
	{
		std::cout << "Left class: DESTRUCTOR" << std::endl;
	}
	void calculate() override
	{
		_derivative = (func(_x) - func(_x - _h)) / _h;
	}
	
};

class Right : public Derivative
{
public:
	Right(double x, double h) : Derivative(x, h)
	{
		std::cout << "Right class: CONSTRUCTOR" << std::endl;
	}
	~Right()
	{
		std::cout << "Right class: DESTRUCTOR" << std::endl;
	}
	void calculate() override
	{
		_derivative = (func(_x + _h) - func(_x)) / _h;
	}
};

class Center : public Derivative
{
public:
	Center(double x, double h) : Derivative(x, h)
	{
		std::cout << "Center class: CONSTRUCTOR" << std::endl;
	}
	~Center()
	{
		std::cout << "Center class: DESTRUCTOR" << std::endl;
	}
	void calculate() override
	{
		_derivative = (func(_x + _h) - func(_x - _h)) / (2 * _h);
	}
};

void main()
{
	std::vector<Derivative*> derivatives;

	derivatives.push_back(new Left(1, 0.1));
	derivatives.push_back(new Right(1, 0.1));
	derivatives.push_back(new Center(1, 0.1));
	
	for (const auto& derivative : derivatives)
	{
		derivative->calculate();
		std::cout << derivative->value() << std::endl;
	}

	for (auto& derivative : derivatives)
		delete derivative;
	derivatives.clear();


}