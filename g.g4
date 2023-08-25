grammar g;

//Tipos de datos y sus reglas
VARIABLE: LETRA (LETRA | DIGITO)*;
INT : DIGITO+;
BOOLEAN: 'verdadero' | 'falso';
STRING : '"' (~["\r\n] | '\\\\' . | '\\"')* '"';
FLOAT: DIGITO+ '.' DIGITO+;
ASSIGN: '=';

// Regla de ignoro
BLANCO: [ \t\r\n] -> skip;

// Reglas de tipo
type: 'booleano' | 'entero' | 'decimal' | 'cadena';

//Reglas de acciones
statement : simple_statement
;

simple_statement : type VARIABLE ASSIGN (STRING | INT | BOOLEAN | FLOAT) ';'
| if_statement
| while_loop
| 'escribe' expression ';';


primary_expression : INT | STRING | BOOLEAN | FLOAT | VARIABLE ;

// Expresiones regulares para letras y números
fragment LETRA : [a-zA-Z] ;
fragment DIGITO : [0-9] ;

//Expresiones matemáticas y lógicas
expr: term
| expr ('+') term
| expr ('-') term
;

term: factor
| term ('*') factor
| term ('/') factor
| term ('%') factor
;

factor: primary
| factor ('^') primary
;

primary: FLOAT
| INT
| '(' expr ')'
;

//Expresiones en bloques
expression: '(' expression ')'
| INT
| FLOAT
| STRING
| BOOLEAN
| VARIABLE
| logical_condition
;

// Regla para condiciones lógicas
igual: '==';
mayor: '>';
menor: '<';
diferente: '!=';
and: '&&';
or: '||';
logical_condition: '(' logical_condition ')'
| BOOLEAN
| '(' VARIABLE mayor (INT | FLOAT | VARIABLE) ')'
| '(' VARIABLE menor (INT | FLOAT| VARIABLE) ')'
| '(' VARIABLE igual (INT | FLOAT | STRING | VARIABLE) ')'
| '(' VARIABLE diferente (INT | FLOAT | STRING | BOOLEAN | VARIABLE) ')'
| logical_condition and logical_condition
| logical_condition or logical_condition
;



// Regla para sentencias 'si' y 'sino'
si: 'si';
sino: 'sino';
if_statement: si logical_condition block
            | si logical_condition block sino block
            ;

//Proceso de anidación
block: '{' statement_list'}';

statement_list: statement
| statement_list statement;

//Reglas gramaticales de mientras
while_loop: 'mientras' expression block;

// Identificación de las sentencias


// Regla raíz
program: statement+;