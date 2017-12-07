package com.kepokepo.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kepokepo.R;
import com.kepokepo.model.ChatData;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ViewHolder> {
    public static final int RIGHT_VIEW_TYPE = 1;
    public static final int LEFT_VIEW_TYPE = 2;

    private List<Integer> listViewType;
    private List<ChatData> listChatData;

    public ChatAdapter(List<Integer> listViewType, List<ChatData>
            listChatData) {
        this.listViewType = listViewType;
        this.listChatData = listChatData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == RIGHT_VIEW_TYPE) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                    .right_chat, null);
            return new rightChatViewHolder(view);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout
                    .left_chat, null);
            return new leftChatViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        int viewType = listViewType.get(position);
        ChatData chatData = listChatData.get(position);
        if (viewType == RIGHT_VIEW_TYPE) {
            rightChatViewHolder rightChatViewHolder = (rightChatViewHolder)
                    holder;
            rightChatViewHolder.rightChatMessageTextView.setText(chatData
                    .getMessage());
            rightChatViewHolder.rightChatTimeTextView.setText(chatData
                    .getTime());
        } else {
            leftChatViewHolder leftChatViewHolder = (leftChatViewHolder) holder;
            leftChatViewHolder.leftChatMessageTextView.setText(Html.fromHtml
                    (chatData.getMessage()));
            leftChatViewHolder.leftChatMessageTextView.setMovementMethod
                    (LinkMovementMethod.getInstance());
            leftChatViewHolder.leftChatTimeTextView.setText(chatData.getTime());
        }
    }

    @Override
    public int getItemCount() {
        return listViewType.size();
    }

    @Override
    public int getItemViewType(int position) {
        return listViewType.get(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class rightChatViewHolder extends ViewHolder {
        private TextView rightChatMessageTextView;
        private TextView rightChatTimeTextView;

        public rightChatViewHolder(View itemView) {
            super(itemView);
            rightChatMessageTextView = (TextView) itemView.findViewById(R.id
                    .text_view_right_chat_message);
            rightChatTimeTextView = (TextView) itemView.findViewById(R.id
                    .text_view_right_chat_time);
        }
    }

    public class leftChatViewHolder extends ViewHolder {
        private TextView leftChatMessageTextView;
        private TextView leftChatTimeTextView;

        public leftChatViewHolder(View itemView) {
            super(itemView);
            leftChatMessageTextView = (TextView) itemView.findViewById(R.id
                    .text_view_left_chat_message);
            leftChatTimeTextView = (TextView) itemView.findViewById(R.id
                    .text_view_left_chat_time);
        }
    }
}
