package com.example.studentcompanionapp.ui.notice;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.BreakIterator;
import java.util.ArrayList;

public abstract class NoticeAdapter<view> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //extends RecyclerView.Adapter<NoticeAdapter.NoticeViewAdapter>
    private final Context context;
    private final ArrayList<NoticeData> list;

    public NoticeAdapter(Context context, ArrayList<NoticeData> list){
      this.context = context;
       this.list = list;
    }
    

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }



    public class NoticeViewAdapter {
        public BreakIterator deleteNoticeTitle;
        public ImageView deleteNoticeImage;
        public View deleteNotice;

        public NoticeViewAdapter(View view) {

        }
    }









        AlertDialog.Builder builder;

/*
        holder.deleteNotice.setOnClickListener((view) {
                builder = new AlertDialog.Builder(context)
                builder.setMessage("Are You Sure You Want To Delete This Notice?")
                builder.setCancelable(true)
        DialogInterface.OnClickListener(new View.OnClickListener()
       // builder.setPositiveButton("OK", (dialogInterface, i){
            DatabaseReference dat = FirebaseDatabase.getInstance().getReference();
            reference.child(currentItem.getKey()).removeValue().addOnCompleteListener((OnCompleteListener) (e) {
                            Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show();
                    }).addOnFailureListener((OnFailureListener) (e) {
                        Toast.makeText(context, "Something Went Wrong", Toast.LENGTH_SHORT).show();
            });
            notifyItemRemoved(position);
        });
                builder.setNegativeButton{
                    "Cancel",
                            (dialogInterface, i){
                        dialogInterface.cancel();
            }
        });
        AlertDialog dialog = null;
        try{
            dialog = builder.create();
        } catch (Exception e){
            e.printStackTrace();
        }

        if(dialog != null)
            dialog.show();

        });



    }
 */


    @Override
    public int getItemCount() { return list.size(); }

/*
    public class NoticeViewAdapter<deleteNotice, deleteNoticeTitle, deleteNoticeImage, itemView> extends RecyclerView.ViewHolder{
        public NoticeViewAdapter(View view) {
            super(view);
        }.NoticeViewAdaptersuper(itemView);
        deleteNotice = itemView.findViewById(R.id.deleteNotice);
        deleteNoticeTitle = itemView.findViewById(R.id.deleteNoticeTitle);
        deleteNoticeImage = itemView.findViewById(R.id.deleteNoticeImage);



    }
*/
 
}
