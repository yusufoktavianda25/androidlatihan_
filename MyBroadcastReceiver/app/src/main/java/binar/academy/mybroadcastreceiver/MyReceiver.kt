package binar.academy.mybroadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // This method is called when the BroadcastReceiver is receiving an Intent broadcast.
        val extras = intent.extras
        if (extras != null){
            val sms = extras.get("key") as Array<*>
            for (i in sms.indices){
                val format = extras.getString("format")
                val smsMessage =
                    android.telephony.SmsMessage.createFromPdu(sms[i] as ByteArray)
                val phoneNumber = smsMessage.originatingAddress
                val messageText = smsMessage.messageBody.toString()
                Toast.makeText(context,
                    "Phone Number : $phoneNumber, MessageText : $messageText", Toast.LENGTH_SHORT).show()
            }
        }
    }
}