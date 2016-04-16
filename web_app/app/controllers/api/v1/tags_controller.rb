module Api
  module V1
    class TagsController < ApplicationController
      before_action :set_tag, only: [:show, :update, :destroy]

      def index
        @tags = Tag.all

        respond_with @tags
      end

      def show
        respond_with @tag
      end

      def create
        @tag = Tag.new(tag_params)
        @tag.save

        respond_with :api, :v1, @tag
      end

      def update
        @tag.update(tag_params)

        respond_with :api, :v1, @tag
      end

      def destroy
        @tag.destroy
        
        respond_with :api, :v1, @tag
      end

      private

      def set_tag
        @tag = Tag.find(params[:id])
      end

      def tag_params
        params.require(:tag).permit(:product_id, :name)
      end
    end
  end
end