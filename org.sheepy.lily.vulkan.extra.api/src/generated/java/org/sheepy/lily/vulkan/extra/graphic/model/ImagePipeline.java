/**
 */
package org.sheepy.lily.vulkan.extra.graphic.model;

import org.eclipse.emf.common.util.EList;
import org.sheepy.lily.vulkan.model.process.AbstractPipeline;
import org.sheepy.lily.vulkan.model.process.AbstractProcess;

import org.sheepy.lily.vulkan.model.resource.Image;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Image Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline#getImage <em>Image</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline#getImageSrcStage <em>Image Src Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline#getImageDstStage <em>Image Dst Stage</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline#getImageSrcAccessMask <em>Image Src Access Mask</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline#getImageDstAccessMask <em>Image Dst Access Mask</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline#getSrcQueue <em>Src Queue</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.extra.graphic.model.GraphicExtraPackage#getImagePipeline()
 * @model
 * @generated
 */
public interface ImagePipeline extends AbstractPipeline
{
	/**
	 * Returns the value of the '<em><b>Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image</em>' reference.
	 * @see #setImage(Image)
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.GraphicExtraPackage#getImagePipeline_Image()
	 * @model required="true"
	 * @generated
	 */
	Image getImage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline#getImage <em>Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image</em>' reference.
	 * @see #getImage()
	 * @generated
	 */
	void setImage(Image value);

	/**
	 * Returns the value of the '<em><b>Image Src Stage</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Src Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #setImageSrcStage(EPipelineStage)
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.GraphicExtraPackage#getImagePipeline_ImageSrcStage()
	 * @model unique="false"
	 * @generated
	 */
	EPipelineStage getImageSrcStage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline#getImageSrcStage <em>Image Src Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Src Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #getImageSrcStage()
	 * @generated
	 */
	void setImageSrcStage(EPipelineStage value);

	/**
	 * Returns the value of the '<em><b>Image Dst Stage</b></em>' attribute.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EPipelineStage}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Dst Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #setImageDstStage(EPipelineStage)
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.GraphicExtraPackage#getImagePipeline_ImageDstStage()
	 * @model unique="false"
	 * @generated
	 */
	EPipelineStage getImageDstStage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline#getImageDstStage <em>Image Dst Stage</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image Dst Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #getImageDstStage()
	 * @generated
	 */
	void setImageDstStage(EPipelineStage value);

	/**
	 * Returns the value of the '<em><b>Image Src Access Mask</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Src Access Mask</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EAccess
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.GraphicExtraPackage#getImagePipeline_ImageSrcAccessMask()
	 * @model
	 * @generated
	 */
	EList<EAccess> getImageSrcAccessMask();

	/**
	 * Returns the value of the '<em><b>Image Dst Access Mask</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Dst Access Mask</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EAccess
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.GraphicExtraPackage#getImagePipeline_ImageDstAccessMask()
	 * @model
	 * @generated
	 */
	EList<EAccess> getImageDstAccessMask();

	/**
	 * Returns the value of the '<em><b>Src Queue</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src Queue</em>' reference.
	 * @see #setSrcQueue(AbstractProcess)
	 * @see org.sheepy.lily.vulkan.extra.graphic.model.GraphicExtraPackage#getImagePipeline_SrcQueue()
	 * @model
	 * @generated
	 */
	AbstractProcess getSrcQueue();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.extra.graphic.model.ImagePipeline#getSrcQueue <em>Src Queue</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src Queue</em>' reference.
	 * @see #getSrcQueue()
	 * @generated
	 */
	void setSrcQueue(AbstractProcess value);

} // ImagePipeline
