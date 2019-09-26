@Regresion
Feature: Iniciar sesion en tripadvisor
  buscar la ciudad Choco, buscar y filtrar por restaurante
  filtrar por estilo de cocina - parrilla, ir al primer resultado
  imprimir un reporte o sea fotos pares - 4 fotos
  filtrar las opiniones regulares - imprimir por consala la unica opnion
  escribir una opinion excelente, llenando el formulario.

  @selecionarDestino
  Scenario: seleccionar destino choco
    Given ingreso a tripadvisor caso "001"
    When  selecciono, filtro e imprimo los items
    Then  diligenciamiento de la oponión excelente