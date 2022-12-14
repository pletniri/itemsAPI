package com.example.itemsAPI.repository.entity;


    import com.example.itemsAPI.controller.dto.ItemDto;
    import jakarta.persistence.Entity;
    import jakarta.persistence.GeneratedValue;
    import jakarta.persistence.GenerationType;
    import jakarta.persistence.Id;
    import com.example.itemsAPI.repository.entity.Item;

    import java.util.Objects;

@Entity
    public class Item
    {

        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Integer id;

        private String name;

        private String description;

        private String imageUrl;

        public Item(String name, String description, String imageUrl) {
            this.name = name;
            this.description = description;
            this.imageUrl = imageUrl;
        }

        public Item() {
        }

        public Item(ItemDto itemDto) {
            this.name = itemDto.getName();
            this.description = itemDto.getDescription();
            this.imageUrl = itemDto.getImageUrl();
        }

        public Integer getId()
        {
            return id;
        }

        public void setId( Integer id )
        {
            this.id = id;
        }

        public String getName()
        {
            return name;
        }

        public void setName( String name )
        {
            this.name = name;
        }

        public String getDescription()
        {
            return description;
        }

        public void setDescription( String description )
        {
            this.description = description;
        }

        public String getImageUrl()
        {
            return imageUrl;
        }

        public void setImageUrl( String imageUrl )
        {
            this.imageUrl = imageUrl;
        }

        @Override
        public boolean equals(Object o) {

            if (this == o)
                return true;
            if (!(o instanceof Item))
                return false;
            Item item = (Item) o;
            return Objects.equals(this.id, item.id) && Objects.equals(this.name, item.name)
                    && Objects.equals(this.description, item.description);
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.id, this.name, this.description);
        }

        @Override
        public String toString()
        {
            return "Item{" +
                    "id=" + id + ", " +
                    "name='" + name + '\'' + ", " +
                    "description='" + description + '\'' + ", " +
                    "imageUrl='"
                    + imageUrl + '}';
        }
    }

