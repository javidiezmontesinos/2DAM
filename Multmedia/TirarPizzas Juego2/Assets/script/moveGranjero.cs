using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class movimientoGranjero : MonoBehaviour

    {
    public float desplazamientoHorizontal;
    public float velocidad = 10f;
    public GameObject ProyectilPrefab;
    // Start is called before the first frame update
    void Start()
    {
        Debug.Log("Ha comenzadoel juego");
    }

    // Update is called once per frame


    void Update()
    {
        //GetKeyDown significa al pulsar la tecla.. con Keycode
        //le decimos que tecla vamos a usar.
        if (Input.GetKeyDown(KeyCode.Space))
        {
            Instantiate(ProyectilPrefab, transform.position,
                ProyectilPrefab.transform.rotation);

        }

        if (transform.position.x < -20)
        {
            transform.position = new Vector3(-20, transform.position.y, transform.position.z);
        }
        if (transform.position.x > 20)
        {
            transform.position = new Vector3(20, transform.position.y, transform.position.z);
        }

        desplazamientoHorizontal = Input.GetAxis("Horizontal");
        //Mover al jugarod horizontalmente
        transform.Translate(Vector3.right * desplazamientoHorizontal * Time.deltaTime * velocidad);

    }
}
