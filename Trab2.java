/**
 * @descrição Neste trabalho desenvolvemos um código com os objetivos de descobrir a idade em anos, meses e dias, o signo, quantos dias faltam para
 * o aniversário e o dia da semana que nasceu do usuário.
 * 
 * 
 * 
 * @author (Tomaz Bettio e Eduardo Juchem Balzan) 
 * @version (OFICIAL :D )
 */

import java.util.Calendar;
import java.util.Scanner;

public class Trab2
{  
  static String[] opcoes = {
      "|1-Descubra a sua idade em anos, meses e dias!", 
      "|2-Descubra seu signo!",  
      "|3-Descubra quantos dias faltam pro seu aniversario!", 
      "|4-Descubra o dia da semana que você nasceu!",
      "|5-Sair"};
      
  public static void main (String[] args)
  {
    Scanner input = new Scanner (System.in);
    
    System.out.println("Escolha uma opção");
        
    for (int i = 0; i < opcoes.length; i++)
    {
      System.out.println(opcoes[i]);
    }

    for (int i = 0; i < 5; i++)
    {
      int opcaoU = input.nextInt();

      switch(opcaoU)
      {
        case 1:
          //OPÇÃO 1
          
          System.out.println("A opção escolhida é:");
          System.out.println(opcoes[0]);

          // DATA ATUAL
          Calendar dataAtual = Calendar.getInstance();
          int diaAtual = dataAtual.get(Calendar.DAY_OF_MONTH);
          int mesAtual = dataAtual.get(Calendar.MONTH);
          int anoAtual = dataAtual.get(Calendar.YEAR);
          mesAtual += 1;

          //IMPRIME DATA ATUAL
          System.out.println("Data atual: ");
          System.out.println(diaAtual + "/" + "0" + mesAtual + "/" + anoAtual);


          // DATA DE NASCIMENTO
          System.out.println("Insira o dia do seu nascimento:");
          int dia = input.nextInt();
          System.out.println("Insira o mês do seu nascimento:");
          int mes = input.nextInt();
          System.out.println("Insira o ano do seu nascimento:");
          int ano = input.nextInt();
            
          // IMPRIME A DATA INSERIDA && OPÇÃO INVÁLIDA
          if((dia < 1 || dia > 31) || (mes < 1 || mes > 12) || (ano < 1900 || ano > 2021))
          {
            System.out.println("Opção inválida!");  
          }
          else
          {
            System.out.println("Data inserida: ");
            System.out.println(dia + "/" + mes + "/" + ano);
          }

              
          // CÁLCULO IDADE
          int calculoDia = 0;
          int calculoMes = 0;
          int calculoAno = 0;
          
          // CALCULO DIA && MÊS && ANO
          calculoAno = anoAtual - ano;
          if(diaAtual > dia && dia != 0)
          {
            if(mesAtual < mes)
            {
              calculoDia = ((diaAtual - dia) - 1);
              calculoMes = (mesAtual + 12) - mes;
              calculoAno -= 1;          
            }
            else if(mesAtual > mes && mes != 0)
            {
              calculoDia = diaAtual - dia;
              calculoMes = mesAtual - mes;
            }
          }
          else if(diaAtual < dia && dia != 0)
          {
            if(mesAtual < mes && mes != 0)
            {
              calculoDia = dia - diaAtual;
              calculoMes = (mesAtual + 12) - mes;
              calculoAno -= 1;          
            }
            else if(mesAtual > mes && mes != 0)
            {
              calculoDia = dia - diaAtual;
              calculoMes = mesAtual - mes;
            }
            else if(mesAtual == mes && dia - diaAtual == 1 && dia != 0)
            {
              calculoDia = diaAtual;
              calculoMes = 11;
              calculoAno -= 1;
            }
          }
          else if (dia == diaAtual && mes < mesAtual)
            {
             calculoDia = dia - diaAtual;
             calculoMes =  mesAtual - mes;
             calculoAno = anoAtual - ano;
            }
          
          // IMPRIME CALCULO
          if(calculoMes >= 0 && calculoDia >= 0)
          {
            System.out.println("A sua idade é:");
            System.out.println(calculoAno + " anos" + " , " + calculoMes + " meses " + " e " + calculoDia + " dias ");
          }
          else if((calculoMes >=  0 && calculoDia >= 0) && (diaAtual == dia && mesAtual == mes))
          {
            System.out.println("A sua idade é:");
            System.out.println(calculoAno + " anos" + " , " + calculoMes + " meses " + " e " + calculoDia + " dias ");
            System.out.println("Parabéns!");
          }
          else if(calculoMes == 1 && calculoDia == 1)
          {
            System.out.println("A sua idade é:");
            System.out.println(calculoAno + " anos " + " , " + calculoMes + " mês" + " e " + calculoDia + " dia ");
          }
          else if (calculoMes >= 0 && dia == diaAtual)
          {
            System.out.println("A sua idade é:");
            System.out.println(calculoAno + " anos " + " , " + calculoMes + " mês" + " e " + calculoDia + " dia ");

          }
          break;
        case 2:
          //OPÇÃO 2

          System.out.println("A opção escolhida é:");
          System.out.println(opcoes[1]);
          System.out.println("Vamos descobrir seu signo!");
          
          // DATA DE NASCIMENTO
          System.out.println("Insira o dia do seu nascimento:");
          int diaS = input.nextInt();
          System.out.println("Insira o mês do seu nascimento:");
          int mesS = input.nextInt();

          // IMPRIME A DATA INSERIDA && OPÇÃO INVÁLIDA 
          if((diaS < 1 || diaS > 31) || (mesS < 1 || mesS > 12))
          {
            System.out.println("Opção inválida!");  
          }
          else
          {
            System.out.println("Data inserida: ");
            System.out.println(diaS + "/" + mesS);
          }

          String[] signos = {"Você é de Aries!", "Você é de Touro!", "Você é de Gemeos!", "Você é de Cancer!", "Você é de Leao!","Você é de Virgem!", "Você é de Libra!", "Você é de Escorpiao!", "Você é de Sagitario!", "Você é de Capricornio!", "Você é de Aquario!", "Você é de Peixes!"};

          // IMPRIME SIGNOS
          for(int z = 0; z < signos.length; z++)
          {
            if ((diaS >= 21 && mesS == 3) || (diaS <= 20 && mesS == 4))
            {
              System.out.println(signos[0]);
              break;
            }
            else if ((diaS >= 21 && mesS == 4) || (diaS <= 20 && mesS == 5))
            {
              System.out.println(signos[1]);
              break;
            }
            else if((diaS >= 21 && mesS == 5) || (diaS <= 20 && mesS == 6))
            {
              System.out.println(signos[2]);
              break;
            }
            else if((diaS >= 21 && mesS == 6) || (diaS <= 22 && mesS == 7))
            {
              System.out.println(signos[3]);
              break;
            }
            else if ((diaS >= 23 && mesS == 7) || (diaS <= 22 && mesS == 8))
            {
              System.out.println(signos[4]);
              break;
            }
            else if((diaS >= 23 && mesS == 8) || (diaS <= 22 && mesS == 9))
            {
              System.out.println(signos[5]);
              break;
            }
            else if((diaS >= 23 && mesS == 9) || (diaS <= 22 && mesS == 10))
            {
              System.out.println(signos[6]);
              break;
            }
            else if((diaS >= 23 && mesS == 10) || (diaS <= 21 && mesS == 11))
            {
              System.out.println(signos[7]);
              break;
            }
            else if((diaS >= 22 && mesS == 11) || (diaS <= 21 && mesS == 12))
            {
              System.out.println(signos[8]);
              break;
            }
            else if((diaS >= 22 && mesS == 12) || (diaS <= 20 && mesS == 1))
            {
              System.out.println(signos[9]);
              break;
            }
            else if((diaS >= 21 && mesS == 1) || (diaS <= 18 && mesS == 2))
            {
              System.out.println(signos[10]);
              break;
            }
            else if((diaS >= 21 && mesS == 2) || (diaS <= 22 && mesS == 3))
            {
              System.out.println(signos[11]);
              break;
            }
          }
          break;
        case 3:
          //OPÇÃO 3

          System.out.println("A opção escolhida é:");
          System.out.println(opcoes[2]);
          
          Calendar dataAtualF = Calendar.getInstance();
          int diaAtualF = dataAtualF.get(Calendar.DAY_OF_MONTH);
          int mesAtualF = dataAtualF.get(Calendar.MONTH);
          int anoAtualF = dataAtualF.get(Calendar.YEAR);
          mesAtualF += 1;

          System.out.println("Insira o dia do seu nascimento:");
          int diaF = input.nextInt();
          System.out.println("Insira o mês do seu nascimento:");
          int mesF = input.nextInt();
          System.out.println("Insira o ano do seu nascimento:");
          int anoF = input.nextInt();
          
          if((diaF < 1 || diaF > 31) || (mesF < 1 || mesF > 12) || (anoF < 1900 || anoF > 2021))
          {
            System.out.println("Opção inválida!");  
          }
          else
          {
            System.out.println("Data inserida: ");
            System.out.println(diaF + "/" + mesF + "/" + anoF);
          }

          // CÁLCULO ANIVERSÁRIO
          int calculoFdia = 0;
          int calculoFmes = 0;
          int calculoFano = 0;
    
          // DiaU MAIOR
          if(diaF > diaAtualF && diaF != 0)
          {
            if (mesF == mesAtualF)
            {
              calculoFdia = diaF - diaAtualF;
          
              if(calculoFdia == 1 && calculoFdia != 0)
              {
                System.out.println("Falta " + calculoFdia + " dia");
              } 
              else if(calculoFdia > 1 && calculoFdia != 0)
              {
                System.out.println("Faltam " + calculoFdia + " dias");
              }
            }
            else if (mesF > mesAtualF && mesF != 0)
            {
              calculoFdia = diaF - diaAtualF;
              calculoFmes = mesF - mesAtualF;
              
              if(calculoFmes > 1 && calculoFdia > 1)
              {
                System.out.println("Faltam " + calculoFmes + " meses e " + calculoFdia + " dias");
              }
              else if(calculoFmes == 1 && calculoFdia == 1)
              {
                System.out.println("Falta " + calculoFmes + " mês e " + calculoFdia + " dia");
              }
              else if(calculoFmes > 1 && calculoFdia == 1)
              {
                System.out.println("Faltam " + calculoFmes + " meses e " + calculoFdia + " dia");
              }
              else if(calculoFmes == 1 && calculoFdia > 1)
              {
                System.out.println("Faltam " + calculoFmes + " mês e " + calculoFdia + " dias");
              }
              else if(calculoFdia > 1 && mesF == mesAtualF)
              {
                System.out.println("Faltam " + calculoFdia + " dias");
              }
              else if(calculoFdia == 1 && mesF == mesAtualF)
              {
                System.out.println("Falta " + calculoFdia + " dia");
              }
            }
            else if(mesF < mesAtualF && mesF != 0)
            {
              calculoFdia = (diaF + 30)- diaAtualF;
              calculoFmes = (mesAtualF - ((mesF + 12) - 1)) * -1;
              
              if(calculoFmes > 1 && calculoFdia > 1)
              {
                System.out.println("Faltam " + calculoFmes + " meses e " + calculoFdia + " dias");
              }
              else if(calculoFmes == 1 && calculoFdia == 1)
              {
                System.out.println("Falta " + calculoFmes + " mês e " + calculoFdia + " dia");
              }
              else if(calculoFmes > 1 && calculoFdia == 1)
              {
                System.out.println("Faltam " + calculoFmes + " meses e " + calculoFdia + " dia");
              }
              else if(calculoFmes == 1 && calculoFdia > 1)
              {
                System.out.println("Faltam " + calculoFmes + " mês e " + calculoFdia + " dias");
              }
              else if(calculoFdia > 1 && mesF == mesAtualF)
              {
                System.out.println("Faltam " + calculoFdia + " dias");
              }
              else if(calculoFdia == 1 && mesF == mesAtualF)
              {
                System.out.println("Falta " + calculoFdia + " dia");
              }
            }
          }
          // DiaU MENOR
          if(diaF < diaAtualF && diaF != 0)
          {
            if (mesF == mesAtualF)
            {
              calculoFdia = diaAtualF - diaF;
          
              if(calculoFdia == 1)
              {
                System.out.println("Falta " + calculoFdia + " dia");
              } 
              else if(calculoFdia > 1)
              {
                System.out.println("Faltam " + calculoFdia + " dias");
              }
            }
            else if(mesAtualF + 1 == mesF)
            {
                calculoFdia = (diaF + 30) - diaAtualF;
                System.out.println("Faltam " + calculoFdia + " dias");
            }
            else if (mesF > mesAtualF && mesF != 0)
            {
              calculoFdia = diaAtualF - diaF;
              calculoFmes = mesF - mesAtualF;
              
              if(calculoFmes > 1 && calculoFdia > 1)
              {
                System.out.println("Faltam " + calculoFmes + " meses e " + calculoFdia + " dias");
              }
              else if(calculoFmes == 1 && calculoFdia == 1)
              {
                System.out.println("Falta " + calculoFmes + " mês e " + calculoFdia + " dia");
              }
              else if(calculoFmes > 1 && calculoFdia == 1)
              {
                System.out.println("Faltam " + calculoFmes + " meses e " + calculoFdia + " dia");
              }
              else if(calculoFmes == 1 && calculoFdia > 1)
              {
                System.out.println("Faltam " + calculoFmes + " mês e " + calculoFdia + " dias");
              }
              else if(calculoFdia > 1 && mesF == mesAtualF)
              {
                System.out.println("Faltam " + calculoFdia + " dias");
              }
              else if(calculoFdia == 1 && mesF == mesAtualF)
              {
                System.out.println("Falta " + calculoFdia + " dia");
              } 
            }
            else if(mesF < mesAtualF && mesF != 0)
            {
              calculoFdia = (diaF + 30) - diaAtualF;
              calculoFmes = (mesAtualF - ((mesF + 12) - 1)) * -1;
              
              if(calculoFmes > 1 && calculoFdia > 1)
              {
                System.out.println("Faltam " + calculoFmes + " meses e " + calculoFdia + " dias");
              }
              else if(calculoFmes == 1 && calculoFdia == 1)
              {
                System.out.println("Falta " + calculoFmes + " mês e " + calculoFdia + " dia");
              }
              else if(calculoFmes > 1 && calculoFdia == 1)
              {
                System.out.println("Faltam " + calculoFmes + " meses e " + calculoFdia + " dia");
              }
              else if(calculoFmes == 1 && calculoFdia > 1)
              {
                System.out.println("Faltam " + calculoFmes + " mês e " + calculoFdia + " dias");
              }
              else if(calculoFdia > 1 && mesF == mesAtualF)
              {
                System.out.println("Faltam " + calculoFdia + " dias");
              }
              else if(calculoFdia == 1 && mesF == mesAtualF)
              {
                System.out.println("Falta " + calculoFdia + " dia");
              } 
            }
          }
          // DiaU IGUAL
          if(diaF == diaAtualF)
          {
            if(mesAtualF + 1 == mesF)
            {
              calculoFmes = mesF - mesAtualF;
              calculoFdia = 0;
              System.out.println("Falta " + calculoFmes + " mês");
            }
            else if (mesF == mesAtualF)
            {
              System.out.println("Seu aniversario é hoje, parabéns!");
            }
            else if (mesF < mesAtualF)
            {
             calculoFmes = (mesAtualF - ((mesF + 12) - 1)) * -1;
             System.out.println("Faltam " + calculoFmes + " meses");
            }
          } 
        break;
        case 4:
          //OPCAO 4 ZELLER

          System.out.println("A opção escolhida é:");
          System.out.println(opcoes[3]);

          String[] diaSemana = {"Você nasceu no Sábado", "Você nasceu no Domingo", "Você nasceu na Segunda-feira","Você nasceu na Terça-feira", "Você nasceu na Quarta-feira", "Você nasceu na Quinta-feira", "Você nasceu na Sexta-feira"};

          int h = 0;
          int q = 0;
          int m = 0;
          int k = 0;
          int j = 0;
          
          System.out.println("Insira o dia do seu aniversário:");
          q = input.nextInt();
          System.out.println("Insira o mês do seu aniversário:");
          m = input.nextInt();
          System.out.println("Insira o ano do seu aniversário:");
          k = input.nextInt();
          System.out.println("Insira o século do seu aniversário:");
          j = input.nextInt();
          
          if((q <= 0 || q > 31) || (m <= 0 || m > 12) || (k <= 0 || k > 2021) || (j <= 0 || j > 21) || (j == 21 && k < 2000) || (j == 20 && k > 2001))
          {
            System.out.println("Opção inválida!");
          }
          else
          {
            h = (q + (((m+1)*26)/10) + k + (k/4) + (j/4) + 5*j) % 7;
            
            for (int s = 0; s < diaSemana.length; s++)
            {
              if(h == 0)
              {
                System.out.println(diaSemana[0]);
                break;
              }
              if(h == 1)
              {
                System.out.println(diaSemana[1]);
                break;
              }
              if(h == 2)
              {
                System.out.println(diaSemana[2]);
                break;            
              }
              if(h == 3)
              {
                System.out.println(diaSemana[3]);
                break;
              }
              if(h == 4)
              {
                System.out.println(diaSemana[4]);
                break;
              }
              if(h == 5)
              {
                System.out.println(diaSemana[5]);
                break;
              }
              if(h == 6)
              {
                System.out.println(diaSemana[6]);
                break;
              }
            }
          }
        break;
        case 5:
        //OPCAO 5
          
          System.out.println("Saindo, até mais!");
          System.exit(opcaoU);
        break;
        default:
          System.out.println("Opção inválida");
          System.out.println("Escolha uma opção válida: ");
          for (int b = 0; b < opcoes.length; b++)
          {
            System.out.println(opcoes[b]);
          }
      }       
    }
  } 
}