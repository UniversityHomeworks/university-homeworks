#include <stdio.h>
#include <stdlib.h>
#define locate (struct node *) malloc(sizeof(struct node))

struct node {
    int data;
    struct node *next;
};

// Inserciones
void insert_right(struct node **);
void insert_left(struct node **);
// Remociones
void delete_right(struct node **);
void delete_left(struct node **);
// Busqueda y impresion
void search_date(struct node **);
void print_list(struct node *);

int main() {
    struct node *cab = NULL;

    int opc = 0;
    while (opc != 6) {
        printf("Ingrese la opcion que desea realizar:\n");
        printf("1.Insertar por derecha\n");
        printf("2.Insertar por izquierda\n");
        printf("3.Borrar por derecha\n");
        printf("4.Borrar por izquierda\n");
        printf("5.Buscar\n");
        printf("6.Salir\n");

        scanf("%d", &opc);

        switch (opc) {
            case 1:
                // Insertar a derecha
                insert_right(&cab);
                break;
            case 2:
                // Insertar a izquierda
                insert_left(&cab);
                break;
            case 3:
                // Eliminar a derecha
                delete_right(&cab);
                break;
            case 4:
                // Eliminar a izquierda
                delete_left(&cab);
                break;
            case 5:
                // Buscar
                search_date(&cab);
                break;
            case 6:
                // Salir, es vacio ya que continua el ciclo y cierra ya que "opc == 6".
                continue;
            default:
                // El dato es incorrecto por tanto reitera poner el dato correcto.
                printf("[!] Dato incorrecto, por favor ingrese una opcion correcta");
                break;
        }
    }
    getchar();
    return 0;
}

// Metodos de insercion
void insert_left (struct node **cab) {
    int number;
    struct node *q;

    printf("[!] Por favor ingrese su dato:\t");
    scanf("%d", &number);

    if (*cab == NULL) {
        q = locate;
        *cab = q;
        q -> data = number;
        q -> next = NULL;
    } else {
        q = locate;
        q -> data = number;
        q -> next = *cab;
        *cab = q;
    }
    print_list(*cab);
}

void insert_right (struct node **cab) {
    int number;
    struct node *q;

    printf("[!] Por favor ingrese su dato:\t");
    scanf("%d", &number);

    q = *cab;
    if (q == NULL) {
        q = locate;
        q -> data = number;
        q -> next = NULL;
        *cab = q;
        print_list(*cab);
        return;
    }

    while(q -> next != NULL) {
        q = q -> next;
    }

    struct node *t;
    t = locate;
    t -> data = number;
    t -> next = NULL;
    q -> next = t;
    print_list(*cab);
}

// Metodos de eliminacion
void delete_left (struct node **cab) {

    struct node *q;
	
	if(*cab == NULL) {
		printf("[*] Lista vacia [*]\n");
        print_list(*cab);
        return;
	}
    q = *cab;
    if(q -> next == NULL) {
		printf("\nEl valor eliminado es: %d\n", q -> data);
		//delete(q);
		*cab = NULL;
	} else {
		printf("\nEl valor eliminado es: %d\n", q -> data);	
		*cab = q -> next;
		free(q);	
	}	
	print_list(*cab);
}

void delete_right (struct node **cab) {
    struct node *q; 

    q = *cab;
    if (q == NULL) {
        printf("[!] LISTA VACIA [!]");
        return;
    }

    if (q -> next == NULL) {
        printf("\nEl valor eliminado es: %d\n", q -> data);
        free(q);
        *cab = NULL;
        print_list(*cab);
        return;
    }

    while (q -> next -> next != NULL) {
        q = q -> next;
    }
    printf("\nEl valor eliminado es: %d\n", q -> data);
    free(q -> next);
    q -> next = NULL;
    print_list(*cab);
}

// Metodos de busqueda y impresion
void search_date (struct node **cab) {
    int number;
    struct node *q;
    q = *cab;

    printf("[!] Ingrese el dato que desee buscar:\t");
    scanf("%d", &number);

    if (q == NULL) {
        printf("[!] NO HAY DATOS QUE BUSCAR EN LA LISTA [!]\n");
        return;
    }

    while (q -> next != NULL) {
        if (q -> data == number) {
            printf("SE ENCONTRÓ EL NUMERO: %i\n", number);
            return;
        }
        q = q -> next;
    }

    if (q -> next == NULL && q -> data == number) {
        printf("SE ENCONTRÓ EL NUMERO: %i\n", number);
        return;
    }

    printf("TAL NUMERO NO SE UBICA EN LA LISTA\n");

}

void print_list (struct node *cab) {
    printf ("La lista es:\n");
	while (cab != NULL) {
		printf("%d\n", cab -> data);
		cab = cab -> next;
	} 
}
