class ImageUploader < CarrierWave::Uploader::Base
  include CarrierWave::MiniMagick

  def store_dir
    "divulgarejo/#{model.class.to_s.underscore}/#{mounted_as}/#{model.id}"
  end
end
