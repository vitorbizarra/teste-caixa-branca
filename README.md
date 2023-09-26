# Exercício individual - Teste de Caixa Branca (ETAPA 1)

## Erros encontrados

1. Variável sendo utilizada com o nome errado na linha 14 em `User.java`:

````java
public Connection conectarDB() {
    Connection connection = null;
    try {
        Class.forName("com.mysql.Driver.Manager").newInstance();
        String url = "jdbc:mysql://127.0.0.1/test?user=lopes&password=123";
        conn = DriverManager.getConnection(url);
        // ^ deveria ser 'connection' da mesma forma como foi declarada
    } catch (Exception e) {
    }
    return connection;
};
````

2. Difícil leitura no seguinte trecho de código:
````java
// [...]

sql += "select nome from usuarios ";
sql += "where login = " + "'" + login + "'";
sql += " and senha = " + "'" + senha + "'";

// [...]
````

3. Varíavel não declarada na linha 33 em `User.java`. Apenas o tipo da variável foi declarado em `ResultSet = st.executeQuery(sql);`. Dessa forma, surgem dois erros de variável não declarada nas linhas abaixo

````java
//[...]

try {
    Statement st = conn.createStatement();
    ResultSet = st.executeQuery(sql); // Local onde deveria ser declarada a variável
    
    if (rs.next()) { // Variável não declarada 
        result = true;
        nome = rs.getString("nome"); // Variável não declarada
    }
} catch (Exception e) {
}

//[...]
````

Para resolver os erros apontados poderíamos reescrever o trecho da seguinte forma:

````java
//[...]

try {
    Statement st = conn.createStatement();
    ResultSet rs = st.executeQuery(sql); // Declarando a variável rs do tipo ResultSet
    
    if (rs.next()) {
        result = true;
        nome = rs.getString("nome");
    }
} catch (Exception e) {
}

//[...]
````
