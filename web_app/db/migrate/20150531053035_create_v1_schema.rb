class CreateV1Schema < ActiveRecord::Migration
  def change
    create_table :people do |t|
      t.string :bio
      t.date :birthday_at
      t.string :email, null: true
      t.string :phone, null: true
      t.string :user_id, null: false
      t.string :image
      t.string :name
      t.string :fb_access_token
      t.text :tags, array: true, default: []

      t.timestamps null: false
    end

    add_index :people, :user_id, unique: true
    add_index :people, :email, unique: true
    add_index :people, :phone, unique: true

    create_table :locations do |t|
      t.decimal :longitude, precision: 10, scale: 6
      t.decimal :latitude, precision: 10, scale: 6
      t.belongs_to :person, index: true

      t.timestamps null: false
    end

    create_table :statuses do |t|
      t.date :last_logged_at
      t.belongs_to :person, index: true

      t.timestamps null: false
    end
  end
end
