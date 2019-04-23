/**
 */
package org.sheepy.vulkan.model.graphicpipeline;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Viewport</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.Viewport#getOffsetX <em>Offset X</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.Viewport#getOffsetY <em>Offset Y</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.Viewport#getExtent <em>Extent</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.Viewport#getMinDepth <em>Min Depth</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.Viewport#getMaxDepth <em>Max Depth</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getViewport()
 * @model
 * @generated
 */
public interface Viewport extends EObject
{
	/**
	 * Returns the value of the '<em><b>Offset X</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset X</em>' attribute.
	 * @see #setOffsetX(int)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getViewport_OffsetX()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getOffsetX();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.Viewport#getOffsetX <em>Offset X</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset X</em>' attribute.
	 * @see #getOffsetX()
	 * @generated
	 */
	void setOffsetX(int value);

	/**
	 * Returns the value of the '<em><b>Offset Y</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Offset Y</em>' attribute.
	 * @see #setOffsetY(int)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getViewport_OffsetY()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getOffsetY();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.Viewport#getOffsetY <em>Offset Y</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Offset Y</em>' attribute.
	 * @see #getOffsetY()
	 * @generated
	 */
	void setOffsetY(int value);

	/**
	 * Returns the value of the '<em><b>Extent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extent</em>' containment reference.
	 * @see #setExtent(Vec2I)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getViewport_Extent()
	 * @model containment="true"
	 * @generated
	 */
	Vec2I getExtent();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.Viewport#getExtent <em>Extent</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extent</em>' containment reference.
	 * @see #getExtent()
	 * @generated
	 */
	void setExtent(Vec2I value);

	/**
	 * Returns the value of the '<em><b>Min Depth</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Depth</em>' attribute.
	 * @see #setMinDepth(int)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getViewport_MinDepth()
	 * @model default="0" unique="false"
	 * @generated
	 */
	int getMinDepth();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.Viewport#getMinDepth <em>Min Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Depth</em>' attribute.
	 * @see #getMinDepth()
	 * @generated
	 */
	void setMinDepth(int value);

	/**
	 * Returns the value of the '<em><b>Max Depth</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Depth</em>' attribute.
	 * @see #setMaxDepth(int)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getViewport_MaxDepth()
	 * @model default="1" unique="false"
	 * @generated
	 */
	int getMaxDepth();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.Viewport#getMaxDepth <em>Max Depth</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Depth</em>' attribute.
	 * @see #getMaxDepth()
	 * @generated
	 */
	void setMaxDepth(int value);

} // Viewport
