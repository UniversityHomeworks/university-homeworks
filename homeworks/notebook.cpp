#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream>
using namespace std;

#define locate (struct node *) malloc(sizeof(struct node *))

struct node {
    struct node *preview;
    int id;
    char name[30];
    char telephone[13];
    char email[40];
    struct node *next;
};

void insert(struct node **);
void search_data(struct node **);
void remove_data(struct node **);
void print_list(struct node *);

void insert(struct node **data) {
    struct node *q = *data;
    int id;
    char name[30];
    char telephone[13];
    char email[40];

    cout << "    1. Digite su identificacion:\t";
    cin >> id;
    fflush(stdin);
    cout << "    2. Digite su nombre completo:\t";
    scanf(" %[^\n]", &name);
    fflush(stdin);
    cout << "    3. Digite su numero telefonico:\t";
    scanf(" %[^\n]", &telephone);
    fflush(stdin);
    cout << "    4. Digite su correo electronico:\t";
    scanf(" %[^\n]", &email);
    fflush(stdin);

    if (*data == NULL) {
        q = locate;
        q -> preview = NULL;
        q -> next = NULL;
        q -> id = id;
        strcpy(q -> name, name);
        strcpy(q -> telephone, telephone);
        strcpy(q -> email, email);
        *data = q;
        print_list(*data);
        return;
    }

    while (q -> next != NULL) {
        q = q -> next;
    }

    q -> next = locate;
    q -> next -> next = NULL;
    q -> next -> preview = q;
    q -> id = id;
    strcpy(q -> name, name);
    strcpy(q -> telephone, telephone);
    strcpy(q -> email, email);
    *data = q;
    print_list(*data);

}

void search_data(struct node **data) {

}

void remove_data(struct node **data) {

}

void print_list (struct node *data) {
    cout << "LOS DATOS EN LA AGENDA SON:\n";
	while (data != NULL) {
        cout << "|*|--------------------[*]--------------------|*|\n";
        cout << "* CEDULA: " << data -> id << "\n";
        cout << "* NOMBRE COMPLETO: " << data -> name << "\n";
        cout << "* TELEFONO: " << data -> telephone << "\n";
        cout << "* CORREO ELECTRONICO: " << data -> email << "\n";
		data = data -> next;
	} 
}


int main() {
    struct node *cab = NULL;
    int opc = 0;
    
    while (opc != 4) {
        cout << "MENU SELECTIVO PARA INSERTAR DATOS EN AGENDA\n" 
             << "\n"
             << "1. INSERTAR DATOS\n"
             << "2. BUSCAR Y ELIMINAR\n"
             << "3. BUSCAR\n"
             << "4. SALIR\n"
             << "\n"
             << "SELECCIONA UNA OPCION:\t";
        cin >> opc;

        switch(opc) {
            case 1:
                insert(&cab);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                continue;
            default:
                cout << "DATO INCORRECTO, INGRESE UN DATO ADECUADO\n"; 
                break;
        }
        fflush(stdin);
    }

    return 0;
}
