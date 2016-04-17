class CreateV1Schema < ActiveRecord::Migration
  def change
    create_table :people do |t|
      t.string :bio
      t.date :birthday_at
      t.string :email, null: true
      t.string :phone, null: true
      t.string :user_id
      t.string :image
      t.string :name
      t.string :fb_access_token
      t.text :tags, array: true, default: []

      t.timestamps null: false
    end

    add_index :people, :user_id, unique: true
    add_index :people, :email, unique: true
    add_index :people, :phone, unique: true
  end
end