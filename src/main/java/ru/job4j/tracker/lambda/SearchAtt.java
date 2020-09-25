package ru.job4j.tracker.lambda;

import java.util.ArrayList;
import java.util.List;

public class SearchAtt {
   public static List<Attachment> filter(List<Attachment> attachments,
                                         Predicate<Attachment> func) {
       List<Attachment> rsl = new ArrayList<>();
       for (Attachment att : attachments) {
           if (func.test(att)) {
               rsl.add(att);
           }
       }
       return rsl;
   }

   public static List<Attachment> filterSize(List<Attachment> attachments) {
       Predicate<Attachment> func = attachment -> attachment.getSize() > 100;
       return filter(attachments, func);
   }

    public static List<Attachment> filterName(List<Attachment> attachments) {
        Predicate<Attachment> func = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains("bug");
            }
        };
        return filter(attachments, func);
    }
}