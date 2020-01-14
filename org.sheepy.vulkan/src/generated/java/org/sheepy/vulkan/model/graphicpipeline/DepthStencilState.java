/**
 */
package org.sheepy.vulkan.model.graphicpipeline;

import org.sheepy.lily.core.api.adapter.ILilyEObject;

import org.sheepy.vulkan.model.enumeration.ECompareOp;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Depth Stencil State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#isDepthTest <em>Depth Test</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#isDepthWrite <em>Depth Write</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#isDepthBoundTest <em>Depth Bound Test</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#isStencilTest <em>Stencil Test</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#getDepthCompareOp <em>Depth Compare Op</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#getMinDepthBounds <em>Min Depth Bounds</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#getMaxDepthBounds <em>Max Depth Bounds</em>}</li>
 * </ul>
 *
 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getDepthStencilState()
 * @model
 * @extends ILilyEObject
 * @generated
 */
public interface DepthStencilState extends ILilyEObject
{
	/**
	 * Returns the value of the '<em><b>Depth Test</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth Test</em>' attribute.
	 * @see #setDepthTest(boolean)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getDepthStencilState_DepthTest()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isDepthTest();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#isDepthTest <em>Depth Test</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth Test</em>' attribute.
	 * @see #isDepthTest()
	 * @generated
	 */
	void setDepthTest(boolean value);

	/**
	 * Returns the value of the '<em><b>Depth Write</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth Write</em>' attribute.
	 * @see #setDepthWrite(boolean)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getDepthStencilState_DepthWrite()
	 * @model default="true" required="true"
	 * @generated
	 */
	boolean isDepthWrite();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#isDepthWrite <em>Depth Write</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth Write</em>' attribute.
	 * @see #isDepthWrite()
	 * @generated
	 */
	void setDepthWrite(boolean value);

	/**
	 * Returns the value of the '<em><b>Depth Bound Test</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth Bound Test</em>' attribute.
	 * @see #setDepthBoundTest(boolean)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getDepthStencilState_DepthBoundTest()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isDepthBoundTest();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#isDepthBoundTest <em>Depth Bound Test</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth Bound Test</em>' attribute.
	 * @see #isDepthBoundTest()
	 * @generated
	 */
	void setDepthBoundTest(boolean value);

	/**
	 * Returns the value of the '<em><b>Stencil Test</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stencil Test</em>' attribute.
	 * @see #setStencilTest(boolean)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getDepthStencilState_StencilTest()
	 * @model default="false" required="true"
	 * @generated
	 */
	boolean isStencilTest();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#isStencilTest <em>Stencil Test</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stencil Test</em>' attribute.
	 * @see #isStencilTest()
	 * @generated
	 */
	void setStencilTest(boolean value);

	/**
	 * Returns the value of the '<em><b>Depth Compare Op</b></em>' attribute.
	 * The default value is <code>"LESS"</code>.
	 * The literals are from the enumeration {@link org.sheepy.vulkan.model.enumeration.ECompareOp}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Depth Compare Op</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ECompareOp
	 * @see #setDepthCompareOp(ECompareOp)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getDepthStencilState_DepthCompareOp()
	 * @model default="LESS" required="true"
	 * @generated
	 */
	ECompareOp getDepthCompareOp();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#getDepthCompareOp <em>Depth Compare Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Depth Compare Op</em>' attribute.
	 * @see org.sheepy.vulkan.model.enumeration.ECompareOp
	 * @see #getDepthCompareOp()
	 * @generated
	 */
	void setDepthCompareOp(ECompareOp value);

	/**
	 * Returns the value of the '<em><b>Min Depth Bounds</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Depth Bounds</em>' attribute.
	 * @see #setMinDepthBounds(float)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getDepthStencilState_MinDepthBounds()
	 * @model default="0" required="true"
	 * @generated
	 */
	float getMinDepthBounds();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#getMinDepthBounds <em>Min Depth Bounds</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Depth Bounds</em>' attribute.
	 * @see #getMinDepthBounds()
	 * @generated
	 */
	void setMinDepthBounds(float value);

	/**
	 * Returns the value of the '<em><b>Max Depth Bounds</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Depth Bounds</em>' attribute.
	 * @see #setMaxDepthBounds(float)
	 * @see org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage#getDepthStencilState_MaxDepthBounds()
	 * @model default="0" required="true"
	 * @generated
	 */
	float getMaxDepthBounds();

	/**
	 * Sets the value of the '{@link org.sheepy.vulkan.model.graphicpipeline.DepthStencilState#getMaxDepthBounds <em>Max Depth Bounds</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Depth Bounds</em>' attribute.
	 * @see #getMaxDepthBounds()
	 * @generated
	 */
	void setMaxDepthBounds(float value);

} // DepthStencilState
