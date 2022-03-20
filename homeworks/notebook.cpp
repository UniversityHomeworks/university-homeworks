#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream>
using namespace std;

#define locate (struct node *) malloc(sizeof(struct node))

struct node {
    struct node *pre;
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
    struct node *q;
    int id;
    char name[30];
    char telephone[13];
    char email[40];

    cout << "    1. Digite su identificacion:\t";
    cin >> id;
    fflush(stdin);
    cout << "    2. Digite su nombre completo:\t";
    scanf(" %[^\n]", name);
    fflush(stdin);
    cout << "    3. Digite su numero telefonico:\t";
    scanf(" %[^\n]", telephone);
    fflush(stdin);
    cout << "    4. Digite su correo electronico:\t";
    scanf(" %[^\n]", email);
    fflush(stdin);

    q =  *data;
    if (*data == NULL) {
        q = locate;
        q -> pre = NULL;
        q -> next = NULL;
        q -> id = id;
        strcpy(q -> name, name);
        strcpy(q -> telephone, telephone);
        strcpy(q -> email, email);
        *data = q;
        print_list(*data);
        return;
    }

    struct node *t;
    t = locate;
    t -> next = NULL;
    t -> pre = q;
    t -> id = id;
    strcpy(t -> name, name);
    strcpy(t -> telephone, telephone);
    strcpy(t -> email, email);
    q -> next = t;
    *data = t;
    print_list(*data);

}

void search_data(struct node **data, int value) {
    struct node *q;
    q = *data;

    if (q == NULL) {
        cout << "[!] NO HAY DATOS QUE BUSCAR EN LA AGENDA [!]\n";
        return;
    }

    while (q -> pre != NULL) {
        if (q -> id == value) {
            cout << "SE ENCONTRÓ LA CEDULA: " << value << "\n";
            return;
        }
        q = q -> pre;
    }

    if (q -> id == value) {
        cout << "SE ENCONTRÓ LA CEDULA: " << value << "\n";
        return;
    }
    cout << "TAL NUMERO NO SE UBICA EN LA AGENDA\n";
}

void remove_data(struct node **data, int value) {
    
    struct node *q;
	
	if(*data == NULL) {
		cout << "[*] LISTA VACIA [*]\n";
        print_list(*data);
        return;
	}

    q = *data;

    while (q -> pre != NULL) {
        if (q -> id == value) {
            cout << "SE ENCONTRÓ LA CEDULA: " << value << " PARA SU ELIMINACION\n";
            break;
        }
        q = q -> pre;
    }

    if(q -> pre == NULL && q -> next == NULL) {
		cout << "\nLA AGENDA TIENE UN SOLO DATO, SE ELIMINA ESE DATO\n";
		*data = NULL;
	} else {
		cout << "\nLOS DATOS FUERON ELIMINADOS\n";
        struct node *next_node = q -> next;
        struct node *previous_node = q -> pre;

        next_node -> pre = previous_node;
        previous_node -> next = next_node; 
		*data = previous_node -> next;
		free(q);
	}	
	print_list(*data);
}

void print_list(struct node *data) {
    if (data == NULL) {
        cout << "DE MOMENTO LA AGENDA ESTA VACIA, POR FAVOR INSERTE DATOS\n";
        return;
    }
    cout << "LOS DATOS EN LA AGENDA SON:\n";
    int i = 1;
	while (data != NULL) {
        cout << "|*|--------------------[#" << i++ << "]--------------------|*|\n";
        cout << "* CEDULA: " << data -> id << "\n";
        cout << "* NOMBRE COMPLETO: " << data -> name << "\n";
        cout << "* TELEFONO: " << data -> telephone << "\n";
        cout << "* CORREO ELECTRONICO: " << data -> email << "\n";
		data = data -> pre;
	} 
}


int main() {
    struct node *cab = NULL;
    int opc = 0;
    
    while (opc != 4) {
        cout << "MENU SELECTIVO PARA INSERTAR DATOS EN AGENDA\n" 
             << "\n"
             << "1. INSERTAR DATOS\n"
             << "2. BUSCAR\n"
             << "3. BUSCAR Y ELIMINAR\n"
             << "4. SALIR\n"
             << "\n"
             << "SELECCIONA UNA OPCION:\t";
        cin >> opc;

        switch(opc) {
            case 1:
                cout << "<< INSERTAR DATOS >>\n";
                insert(&cab);
                break;
            case 2:
                cout << "<< BUSCAR >>\n";
                int n;
                cout << "INGRESE LA CEDULA A BUSCAR:\t";
                cin >> n;
                search_data(&cab, n);
                break;
            case 3:
                cout << "<< BUSCAR & ELIMINAR >>\n";
                int b;
                cout << "INGRESE LA CEDULA A ELIMINAR:\t";
                cin >> b;
                remove_data(&cab, b);
                break;
            case 4:
                continue;
            default:
                cout << "<< DATO INCORRECTO, INGRESE UNA OPCION ADECUADA >>\n"; 
                break;
        }
        fflush(stdin);
    }

    return 0;
}
