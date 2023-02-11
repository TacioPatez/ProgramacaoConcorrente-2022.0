#include <unistd.h>
#include <iostream>
#include <time.h>

using namespace std;

int main()
{
  pid_t idThread; // variavel da thread
  cout << "Pai Nasceu - ID: " << getpid() << endl;
  sleep(22);

  idThread = fork();

  if (idThread == -1)
  {
    exit(1);
  }

  if (idThread == 0)
  { // Processo do Filho1 Iniciado
    cout << "Filho 1 - ID: " << getpid() << " Nasceu." << endl;
    sleep(16);

    idThread = fork();

    if (idThread == -1)
    {
      exit(1);
    }

    if (idThread == 0)
    { // Processo do Neto1 Iniciado
      cout << "Neto 1 - ID: " << getpid() << " Nasceu." << endl;
      sleep(30);

      idThread = fork();

      if (idThread == -1)
      {
        exit(1);
      }

      if (idThread == 0)
      { // Processo do Bisneto Iniciado
        cout << "Bisneto - ID: " << getpid() << " Nasceu." << endl;
        sleep(12);
        cout << "Bisneto - ID: " << getpid() << " Morreu aos 12 anos." << endl;
        exit(0);
      }
      else
      {
        sleep(5);
        cout << "Neto 1 - ID: " << getpid() << " Morreu aos 35 anos." << endl;
        exit(0);
      }
    }
    else
    {
      sleep(45);
      cout << "Filho 1 - ID: " << getpid() << " Morreu aos 61 anos." << endl;
      exit(0);
    }
  }
  else
  { // Processo do Pai
    sleep(3);
    idThread = fork();

    if (idThread == -1)
    {
      exit(1);
    }

    if (idThread == 0)
    { // Processo do Filho2 Iniciado
      cout << "Filho 2 - ID: " << getpid() << " Nasceu." << endl;
      sleep(20);

      idThread = fork();

      if (idThread == -1)
      {
        exit(1);
      }

      if (idThread == 0)
      { // Processo do Neto2 Iniciado
        cout << "Neto2 - ID: " << getpid() << " Nasceu." << endl;
        sleep(33);
        cout << "Neto 2 - ID: " << getpid() << " Morreu aos 33 anos." << endl;
        exit(0);
      }
      else
      { // Processo do Filho2
        sleep(25);
        cout << "Filho 2 - ID: " << getpid() << " Morreu aos 55 anos." << endl;
        exit(0);
      }
    }
    else
    { // Processo do Pai
      sleep(7);
      idThread = fork();

      if (idThread == -1)
      {
        exit(1);
      }

      if (idThread == 0)
      { // Processo do Filho3 Iniciado
        cout << "Filho 3 - ID: " << getpid() << " Nasceu." << endl;
        sleep(55);
        cout << "Filho 3 - ID: " << getpid() << " Morreu aos 55 anos." << endl;
        exit(0);
      }
      else
      { // Processo do Pai
        sleep(58);
        cout << "Pai Morreu - ID: " << getpid() << " Morreu aos 90 anos." << endl;
        exit(0);
      }
    }
  }
}