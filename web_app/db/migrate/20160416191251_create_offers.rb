class CreateOffers < ActiveRecord::Migration
  def change
    create_table :offers do |t|
      t.references :company, index: true, foreign_key: true
      t.string :title
      t.string :description
      t.date :due_date

      t.timestamps null: false
    end
  end
end
