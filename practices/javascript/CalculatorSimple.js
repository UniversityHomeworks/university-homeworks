//Simple calculator

let x, y;
let result;

function main() {
    x = 5;
    y = 10;
    console.log("X = " + x + ", Y = " + y);
    printResult();

    x = 8;
    y = 7;
    console.log("X = " + x + ", Y = " + y);
    printResult();

    x = 77;
    y = 0;
    console.log("X = " + x + ", Y = " + y);
    printResult();

    x = 55;
    y = 3;
    console.log("X = " + x + ", Y = " + y);
    printResult();

}

function addition() {
    return x + y;
}

function subtraction() {
    return x - y;
}

function multiplication() {
    return x * y;
}

function division() {
    if (y == 0) {
        console.log("No se puede dividir por 0");
        return 0;
    }
    return x / y;
}

function printResult() {
    console.log("El resultado de la suma es: " + addition());
    console.log("El resultado de la resta es: " + subtraction());
    console.log("El resultado de la multiplicacion es: " + multiplication());
    console.log("El resultado de la division es: " + division());
}

main();