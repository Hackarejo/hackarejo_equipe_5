class CreateVouchers < ActiveRecord::Migration
  def change
    create_table :vouchers do |t|
      t.references :offer, index: true, foreign_key: true
      t.string :code

      t.timestamps null: false
    end
  end
end
