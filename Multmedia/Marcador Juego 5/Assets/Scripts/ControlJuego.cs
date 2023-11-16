using System.Collections;
using System.Collections.Generic;
using TMPro;
using UnityEngine;

public class ControlJuego : MonoBehaviour
{
    // Start is called before the first frame update
    //vamos a usar list en vez arrays
    public List<GameObject> objetivos;
    public TextMeshProUGUI textoMarcador; //a�adimos el objeto marcador en unity
    private float retrasoGeneracion = 1.0f; //retraso de un segundo
    private int marcador; //variable marcador
    public TextMeshProUGUI textoGameOver;
    void Start()
    {
        marcador = 0;//inicializamos el marcador
        StartCoroutine(GenerarObjetivos());//llamamos a la corrutina
        ActualizarMarcador(0);
        Debug.Log(marcador);
    }

    // Update is called once per frame
    void Update()
    {

    }
    IEnumerator GenerarObjetivos()
    {
        //retardamos la tasa de espera de la generacion de enemigos
        while (true)
        {
            yield return new WaitForSeconds(retrasoGeneracion);
            int index = Random.Range(0, objetivos.Count);//count es como length
            Instantiate(objetivos[index]); //cada segundo generar� un objetivo, y mientras sea true
            //generar� una figura.
        }

    }

    //creamos un m�todo que sume puntos al marcador
    public void ActualizarMarcador(int puntosASumar)
    {

        marcador += puntosASumar;
        textoMarcador.text = "Puntos " + marcador;
    }
    public void GameOver() {
        Debug.Log("HA TERMINADO EL JUEGO");
       textoGameOver.gameObject.SetActive(true);

    }

}

