class CreateCompanies < ActiveRecord::Migration
  def change
    create_table :companies do |t|
      t.references :responsible, index: true
      t.string :name
      t.string :phone
      t.string :latitude
      t.string :longitude

      t.timestamps null: false
    end

    add_foreign_key :companies, :users, column: :responsible_id
  end
end
