#include <iostream>
#include <stdio.h>
using namespace std;

int vector_addition(int vec[], int n) {
    if (n == 0) return vec[n];
    else {
        n--;
        return vec[n + 1] + vector_addition(vec, n);
    }
}

void print_vector(int vec[], int n) {
    if (10 != n) {
        cout << "DATO: " << vec[n] << "\n";
        print_vector(vec, n + 1);
    }
}

void search_vector(int vec[], int n, int date) {
    if (10 == n) {
        cout << "NO SE ENCONTRA EL DATO\n";
        return;
    }
    if (vec[n] == date) {
        cout << "SE ENCONTRO EL DATO: " << date << "\n";
        return;
    }
    search_vector(vec, n + 1, date);
}

int main() {
    int opc = 0;
    int vec[10] = {1,2,3,4,5,6,7,8,9,10};
    
    while (opc != 4) {
        cout << "[+] MENU SELECTIVO [+]\n";
        cout << "   1. SUMAR VECTOR\n";
        cout << "   2. BUSCAR\n";
        cout << "   3. IMPRIMIR\n";
        cout << "   4. SALIR\n";
        cout << "INGRESE UNA OPCION VALIDA: \t";
        cin >> opc;
        
        
        switch(opc) {
            case 1:
                cout << "SUMAR\n";
                cout << "EL RESULTADO DE LA SUMA ES: " << vector_addition(vec, 9) << "\n";
                break;
            case 2:
                cout << "BUSCAR\n";
                int n;
                cout << "INGRESE EL DATO A BUSCAR: \t";
                cin >> n;
                search_vector(vec, 0, n);
                break;
            case 3:
                cout << "IMPRIMIR\n";
                print_vector(vec, 0);
                break;
            case 4:
                continue;
            default:
                cout << "Numero incorrecto, por favor valide.\n";
                break;
            
        }
        
    }

    return 0;
}
