def main() :
    x = 0;
    y = 0;
    opc = 0;
    while opc != 5:

        print('1. SUMAR')
        print('2. RESTAR')
        print('3. MULTIPLICAR')
        print('4. DIVIDIR')
        print('5. SALIR')
        opc = input('Digite la operacion a realizar: ')
        print(opc)

        if opc == 1:
            x = input('DIGITE EL NUMERO X:')
            y = input('DIGITE EL NUMERO Y:')
            print(addition(x, y))
        elif opc == 2:
            break
        elif opc == 3:
            break
        elif opc == 4:
            break
        elif opc == 5:
            continue
        else :
            break
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