module Api
  module V1
    class ProductsController < ApplicationController
      before_action :set_product, only: [:show, :update, :destroy]

      def index
        @products = Product.all

        respond_with @products
      end

      def show
        respond_with @product
      end

      def create
        @product = Product.new(product_params)
        @product.save

        respond_with :api, :v1, @product
      end

      def update
        @product.update(product_params)

        respond_with :api, :v1, @product
      end

      def destroy
        @product.destroy
        
        respond_with :api, :v1, @product
      end

      private

      def set_product
        @product = Product.find(params[:id])
      end

      def product_params
        params.require(:product).permit(:company_id, :name, :price)
      end
    end
  end
end