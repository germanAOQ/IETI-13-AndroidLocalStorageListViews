package co.edu.eci.ieti.android.network.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import co.edu.eci.ieti.R;
import co.edu.eci.ieti.android.network.data.Task;

public class TasksAdapter
        extends RecyclerView.Adapter<TasksAdapter.ViewHolder>
{

    List<Task> taskList = null;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType )
    {
        return new ViewHolder( LayoutInflater.from( parent.getContext() ).inflate(R.layout.task_row, parent, false ) );
    }

    @Override
    public void onBindViewHolder( @NonNull ViewHolder holder, int position )
    {
        Task task = taskList.get( position );
        holder.getTextViewTitle().setText(task.getTitle());
        holder.getTextViewStatus().setText(task.getStatus());
        holder.getTextViewDate().setText(task.getDueDate());
        holder.getTextViewResponsable().setText(task.getResponsable());

    }

    @Override
    public int getItemCount()
    {
        return taskList != null ? taskList.size() : 0;
    }

    public void updateTasks(List<Task> tasks){
        this.taskList = tasks;
        notifyDataSetChanged();
    }

    class ViewHolder
            extends RecyclerView.ViewHolder
    {
        private TextView textViewTitle;
        private TextView textViewStatus;
        private TextView textViewDate;
        private TextView textViewResponsable;


        ViewHolder( @NonNull View itemView )
        {
            super( itemView );
            textViewTitle = itemView.findViewById(R.id.title);
            textViewStatus = itemView.findViewById(R.id.status);
            textViewDate = itemView.findViewById(R.id.date);
            textViewResponsable = itemView.findViewById(R.id.responsable);
        }

        public TextView getTextViewTitle() {
            return textViewTitle;
        }

        public TextView getTextViewStatus() {
            return textViewStatus;
        }

        public TextView getTextViewDate() {
            return textViewDate;
        }

        public TextView getTextViewResponsable() {
            return textViewResponsable;
        }
    }

}
