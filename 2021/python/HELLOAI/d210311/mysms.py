from sdk.api.message import Message
import sys
from sdk.exceptions import CoolsmsException


# @brief This sample code demonstrate how to send sms through CoolSMS Rest API PHP
class MyMessage:
    @classmethod
    def mysendmsms(cls, mobile, url):
        # set api key, api secret
        api_key = "NCSE7T2DQPUITPUV"
        api_secret = "MYYNIOI48LMZJKL0BBOZXFAWV0MKMURH"

        # 4 params(to, from, type, text) are mandatory. must be filled
        params = dict()
        params['type'] = 'sms'  # Message type ( sms, lms, mms, ata )
        params['to'] = mobile  # Recipients Number '01000000000,01000000001'
        params['from'] = '01063080737'  # Sender number
        params['text'] = url  # Message

        cool = Message(api_key, api_secret)
        try:
            response = cool.send(params)
            print("Success Count : %s" % response['success_count'])
            print("Error Count : %s" % response['error_count'])
            print("Group ID : %s" % response['group_id'])

            if "error_list" in response:
                print("Error List : %s" % response['error_list'])

        except CoolsmsException as e:
            print("Error Code : %s" % e.code)
            print("Error Message : %s" % e.msg)
