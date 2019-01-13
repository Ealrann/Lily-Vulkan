/**
 */
package org.sheepy.vulkan.model.process.graphic;

import org.eclipse.emf.common.util.EList;
import org.sheepy.vulkan.model.enumeration.EAccess;
import org.sheepy.vulkan.model.enumeration.EPipelineStage;

import org.sheepy.vulkan.model.process.AbstractPipeline;

import org.sheepy.vulkan.model.resource.Image;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Image Pipeline</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.ImagePipeline#getImage <em>Image</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.ImagePipeline#getImageSrcStage <em>Image Src Stage</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.ImagePipeline#getImageDstStage <em>Image Dst Stage</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.ImagePipeline#getImageSrcAccessMask <em>Image Src Access Mask</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.process.graphic.ImagePipeline#getImageDstAccessMask <em>Image Dst Access Mask</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getImagePipeline()
 * @model
 * @generated
 */
public interface ImagePipeline extends AbstractPipeline
{
	/**
	 * Returns the value of the '<em><b>Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image</em>' reference.
	 * @see #setImage(Image)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getImagePipeline_Image()
	 * @model required="true"
	 * @generated
	 */
	Image getImage();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.ImagePipeline#getImage <em>Image</em>}' reference.
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
	 * <p>
	 * If the meaning of the '<em>Image Src Stage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Src Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #setImageSrcStage(EPipelineStage)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getImagePipeline_ImageSrcStage()
	 * @model unique="false"
	 * @generated
	 */
	EPipelineStage getImageSrcStage();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.ImagePipeline#getImageSrcStage <em>Image Src Stage</em>}' attribute.
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
	 * <p>
	 * If the meaning of the '<em>Image Dst Stage</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Dst Stage</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EPipelineStage
	 * @see #setImageDstStage(EPipelineStage)
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getImagePipeline_ImageDstStage()
	 * @model unique="false"
	 * @generated
	 */
	EPipelineStage getImageDstStage();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.process.graphic.ImagePipeline#getImageDstStage <em>Image Dst Stage</em>}' attribute.
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
	 * <p>
	 * If the meaning of the '<em>Image Src Access Mask</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Src Access Mask</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EAccess
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getImagePipeline_ImageSrcAccessMask()
	 * @model unique="false"
	 * @generated
	 */
	EList<EAccess> getImageSrcAccessMask();

	/**
	 * Returns the value of the '<em><b>Image Dst Access Mask</b></em>' attribute list.
	 * The list contents are of type {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EAccess}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Image Dst Access Mask</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image Dst Access Mask</em>' attribute list.
	 * @see org.sheepy.vulkan.model.enumeration.EAccess
	 * @see org.sheepy.vulkan.model.process.graphic.GraphicPackage#getImagePipeline_ImageDstAccessMask()
	 * @model unique="false"
	 * @generated
	 */
	EList<EAccess> getImageDstAccessMask();

} // ImagePipeline
