def main() :

    print('\nX = ' + str(5) + ', y = ' + str(6))
    print_results(5, 6)

    print('\nX = ' + str(10) + ', y = ' + str(8))
    print_results(10, 8)

    print('\nX = ' + str(99) + ', y = ' + str(10))
    print_results(99, 10)

    print('\nX = ' + str(33) + ', y = ' + str(0))
    print_results(33, 0)
    return

def addition(x, y) :
    return x + y

def subtraction(x, y) :
    return x - y

def multiplication(x, y) :
    return x * y

def division(x, y) :
    if (y == 0) :
        print('No se puede dividir por 0, por ende su resultado será 0')
        return 0
    return x / y

def print_results(x, y) :
    print('La suma es: ' + str(addition(x, y)))
    print('La resta es: ' + str(subtraction(x, y)))
    print('La multiplicacion es: ' + str(multiplication(x, y)))
    print('La division es: ' + str(division(x, y)))
    return


main()