using System.Collections;
using System.Collections.Generic;
using UnityEngine;


public class NewBehaviourScript : MonoBehaviour
{
    public float velocidad=20.0f;
    public float velocidadGiro=25f;
    public float controlHorizontal;
    public float controlAvance;
    


    // Start is called before the first frame update
    void Start()
    {
        // Antes del frame del juego
    }


    // Update is called once per frame
    void Update()
    {
        controlHorizontal= Input.GetAxis("Horizontal");
        controlAvance= Input.GetAxis("Vertical");
        
        // Cada vez que se avanza un fotograma, es el tiempo en segundos, podría ser un metro por segundo
        transform.Translate(Vector3.forward * Time.deltaTime*velocidad*controlAvance);
        transform.Translate(Vector3.right * Time.deltaTime*velocidadGiro*controlHorizontal);
        transform.Translate(Vector3.up * Time.deltaTime*velocidadGiro*controlHorizontal);
        




    }
}
