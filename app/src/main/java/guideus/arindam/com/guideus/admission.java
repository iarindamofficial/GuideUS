package guideus.arindam.com.guideus;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class admission extends Fragment {

    DatabaseReference rootRef,demoRef,demoRef1;
    public admission() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v= inflater.inflate(R.layout.fragment_admission_n, container, false);


        final EditText e1,e2,e3,e4,e5,e6,e7;

        e1=(EditText)v.findViewById(R.id.adEmail);
        e2=(EditText)v.findViewById(R.id.adStream);
        e3=(EditText)v.findViewById(R.id.adName);
        e4=(EditText)v.findViewById(R.id.adFather);
        e5=(EditText)v.findViewById(R.id.adGender);
        e6=(EditText)v.findViewById(R.id.adAddress);
        e7=(EditText)v.findViewById(R.id.adPhone);

        Button submit = (Button)v.findViewById(R.id.adSubmit);
        FirebaseApp.initializeApp(v.getContext());
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rootRef = FirebaseDatabase.getInstance().getReference();

                //database reference pointing to demo node
                demoRef = rootRef.child("user");


//             final  String value1 = e1.getText().toString();
//               final String value2 = e2.getText().toString();
//               final String value3 = e3.getText().toString();
//               final String value4 = e4.getText().toString();
//               final String value5 = e5.getText().toString();
//               final  String value6 = e6.getText().toString();
//               final String value7 = e7.getText().toString();


//                   demoRef.push().setValue(value1);
//                   demoRef.push().setValue(value2);
//                   demoRef.push().setValue(value5);
//                   demoRef.push().setValue(value3);
//                   demoRef.push().setValue(value4);
                //demoRef.push().setValue("test");

                String email = (String)e1.getText().toString();
                String stream=(String)e2.getText().toString();
                String name=(String)e3.getText().toString();
                String Fname=(String)e4.getText().toString();
                String gender=(String)e5.getText().toString();
                String add=(String)e6.getText().toString();
                String phone=(String)e7.getText().toString();
                demoRef1=demoRef.child(name);
                demoRef1.push().setValue(email);
                demoRef1.push().setValue(stream);
                demoRef1.push().setValue(name);
                demoRef1.push().setValue(Fname);
                demoRef1.push().setValue(gender);
                demoRef1.push().setValue(add);
                demoRef1.push().setValue(phone);



                Toast.makeText(v.getContext(),"Thank you for registration!",Toast.LENGTH_SHORT).show();
                dashboard dashboard = new dashboard();
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragmentAdmission,dashboard);
                getActivity().setTitle("Home");
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();



            }
        });

        // Inflate the layout for this fragment
        return v;
    }

}