def search_single_in_sequence(char, sequence):
    sequence_list = list(sequence)
    in_sequence = False

    for i in range(len(sequence_list)):
        if sequence_list[i] == char:
            in_sequence = True
            break
    return in_sequence


def rot13(message):
    final_message = ""
    message_list = list(message)
    sequence_list = list("ABCDEFGHIJKLMNOPQRSTUVWXYZ")

    for i in range(len(message_list)):
        if search_single_in_sequence(message_list[i], sequence_list):
            char_index = sequence_list.index(message_list[i])
            override_index = (char_index + 13) % len(sequence_list)
            final_message += sequence_list[override_index]
        elif search_single_in_sequence(message_list[i].upper(), sequence_list):
            char_index = sequence_list.index(message_list[i].upper())
            override_index = (char_index + 13) % len(sequence_list)
            final_message += sequence_list[override_index].lower()
        else:
            final_message += message_list[i]

    return final_message
