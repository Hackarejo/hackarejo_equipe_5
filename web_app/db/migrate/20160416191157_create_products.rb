class CreateProducts < ActiveRecord::Migration
  def change
    create_table :products do |t|
      t.references :company, index: true, foreign_key: true
      t.string :name
      t.decimal :price, precision: 10, scale: 2

      t.timestamps null: false
    end
  end
end
