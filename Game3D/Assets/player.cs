using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
public class player : MonoBehaviour
{
    
    public float speed = 1/1000000000;
    private Rigidbody rb;
    public float nhaycao = 0f;
    bool co_nhay;
    bool right;
    bool left;
    private float time;
    private float nhan;

    // Start is called before the first frame update
    void Start()
    {
        rb = GetComponent<Rigidbody>();
        co_nhay = false;
        right = false;
        left = false;
        time = Time.frameCount;
       
       
    }
  
    // Update is called once per frame
    void Update()
    {
        nhan = time / 10;
        rb.AddForce(0,0,speed);
        Debug.Log(time);
        //NhayLen();

        //if (left) {
        //rb.AddForce(transform.position.x + 2, 0, 0);
        //  transform.position;
        //}
    }
    private void OnCollisionEnter(Collision collision)
    {
        if (collision.gameObject.tag == "Ground" && co_nhay == false) {
            co_nhay = true;
            Debug.Log("chạm đất");
        }
    }
    private void OnTriggerEnter(Collider other)
    {
        if (other.gameObject.tag == "GroundReset")
        {
            SceneManager.LoadScene("Reset");
        }
    }
    public void NhayLen() {
        nhaycao = 45f;
        if (co_nhay) {
            rb.AddForce(new Vector3(0 ,nhaycao, 0),ForceMode.Impulse );
            co_nhay = false;
            Debug.Log("nhay len");
           
        }
    }
    public void SangTrai()
    {
        //left = true;
        //transform.Translate(1, 0, 0);
        rb.AddForce(transform.position.x + 2, 0, 0);
        //left = false;



    }
    public void SangPhai()
    {
        right = true;
        //right = false;
    }
    

}
