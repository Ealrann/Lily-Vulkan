/**
 */
package org.sheepy.lily.vulkan.model.process.graphic;

import org.joml.Vector3ic;
import org.sheepy.lily.vulkan.model.process.IPipelineTask;

import org.sheepy.lily.vulkan.model.resource.Image;

import org.sheepy.vulkan.model.enumeration.EFilter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Blit To Swap Image</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.BlitToSwapImage#getImage <em>Image</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.BlitToSwapImage#getFilter <em>Filter</em>}</li>
 *   <li>{@link org.sheepy.lily.vulkan.model.process.graphic.BlitToSwapImage#getClearColor <em>Clear Color</em>}</li>
 * </ul>
 *
 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getBlitToSwapImage()
 * @model
 * @generated
 */
public interface BlitToSwapImage extends IPipelineTask
{
	/**
	 * Returns the value of the '<em><b>Image</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Image</em>' reference.
	 * @see #setImage(Image)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getBlitToSwapImage_Image()
	 * @model required="true"
	 * @generated
	 */
	Image getImage();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.BlitToSwapImage#getImage <em>Image</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Image</em>' reference.
	 * @see #getImage()
	 * @generated
	 */
	void setImage(Image value);

	/**
	 * Returns the value of the '<em><b>Filter</b></em>' attribute.
	 * The default value is <code>"NEAREST"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.EFilter}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EFilter
	 * @see #setFilter(EFilter)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getBlitToSwapImage_Filter()
	 * @model default="NEAREST" unique="false"
	 * @generated
	 */
	EFilter getFilter();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.BlitToSwapImage#getFilter <em>Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.EFilter
	 * @see #getFilter()
	 * @generated
	 */
	void setFilter(EFilter value);

	/**
	 * Returns the value of the '<em><b>Clear Color</b></em>' attribute.
	 * The default value is <code>"0;0;0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Clear Color</em>' attribute.
	 * @see #setClearColor(Vector3ic)
	 * @see org.sheepy.lily.vulkan.model.process.graphic.GraphicPackage#getBlitToSwapImage_ClearColor()
	 * @model default="0;0;0" dataType="org.sheepy.lily.core.model.types.Vector3i" required="true"
	 * @generated
	 */
	Vector3ic getClearColor();

	/**
	 * Sets the value of the '{@link org.sheepy.lily.vulkan.model.process.graphic.BlitToSwapImage#getClearColor <em>Clear Color</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Clear Color</em>' attribute.
	 * @see #getClearColor()
	 * @generated
	 */
	void setClearColor(Vector3ic value);

} // BlitToSwapImage
