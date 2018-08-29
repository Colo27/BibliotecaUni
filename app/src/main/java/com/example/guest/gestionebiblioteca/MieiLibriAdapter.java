package com.example.guest.gestionebiblioteca;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class MieiLibriAdapter extends RecyclerView.Adapter<MieiLibriAdapter.MieiLibriViewHolder> {


    private Activity mActivity;
    private DatabaseReference mDataBaseReference;
    private String mDisplayName;
    private ArrayList<DataSnapshot> mDataSnapshot;
    private ArrayList<Libro> moviesList = new ArrayList<>();
    private String mUser;
    private  MieiLibriViewHolder vholder;
    private Context mContext;

    private ChildEventListener mListener = new ChildEventListener() {
        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            mDataSnapshot.add(dataSnapshot);
            notifyDataSetChanged();
        }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    };

    public MieiLibriAdapter(Context context, Activity activity, DatabaseReference ref, String categoria, String user){

        mActivity = activity;
        mDataBaseReference  = ref.child("users").child(user);
        mDataSnapshot = new ArrayList<>();
        mContext = context;
        mUser=user;

        mDataBaseReference.addChildEventListener(mListener);

    }


    public class MieiLibriViewHolder extends RecyclerView.ViewHolder{

        TextView titolo;
        TextView autore;

        public MieiLibriViewHolder(View itemView) {
            super(itemView);
            titolo =(TextView)itemView.findViewById(R.id.item_titolo);
            autore =(TextView)itemView.findViewById(R.id.item_autore);

        }
    }


    @Override
    public MieiLibriViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = (LayoutInflater)mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.recycleview_item_row, parent, false);
        vholder = new MieiLibriViewHolder(v);

        return vholder;

    }

    @Override
    public void onBindViewHolder(final MieiLibriViewHolder holder, final int position) {

        final DataSnapshot snapshot = mDataSnapshot.get(position);

        final Libro libro = snapshot.getValue(Libro.class);

        holder.titolo.setText(libro.getmTitolo());

        moviesList.add(libro);

        holder.titolo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, Restituisci.class);
                intent.putExtra("titolo", moviesList.get(position).getmTitolo());
                intent.putExtra("autore", moviesList.get(position).getmAutore());
                intent.putExtra("key", snapshot.getKey());
                intent.putExtra("user", mUser);

                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSnapshot.size();
    }


    public void clean(){
        mDataBaseReference.removeEventListener(mListener);
    }


}

