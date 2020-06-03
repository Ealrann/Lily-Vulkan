/**
 */
package org.sheepy.vulkan.model.graphicpipeline.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.sheepy.lily.core.api.model.LilyEObject;

import org.sheepy.vulkan.model.enumeration.ECompareOp;

import org.sheepy.vulkan.model.graphicpipeline.DepthStencilState;
import org.sheepy.vulkan.model.graphicpipeline.GraphicpipelinePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Depth Stencil State</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.DepthStencilStateImpl#isDepthTest <em>Depth Test</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.DepthStencilStateImpl#isDepthWrite <em>Depth Write</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.DepthStencilStateImpl#isDepthBoundTest <em>Depth Bound Test</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.DepthStencilStateImpl#isStencilTest <em>Stencil Test</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.DepthStencilStateImpl#getDepthCompareOp <em>Depth Compare Op</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.DepthStencilStateImpl#getMinDepthBounds <em>Min Depth Bounds</em>}</li>
 *   <li>{@link org.sheepy.vulkan.model.graphicpipeline.impl.DepthStencilStateImpl#getMaxDepthBounds <em>Max Depth Bounds</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DepthStencilStateImpl extends LilyEObject implements DepthStencilState
{
	/**
	 * The default value of the '{@link #isDepthTest() <em>Depth Test</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDepthTest()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEPTH_TEST_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isDepthTest() <em>Depth Test</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDepthTest()
	 * @generated
	 * @ordered
	 */
	protected boolean depthTest = DEPTH_TEST_EDEFAULT;

	/**
	 * The default value of the '{@link #isDepthWrite() <em>Depth Write</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDepthWrite()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEPTH_WRITE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isDepthWrite() <em>Depth Write</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDepthWrite()
	 * @generated
	 * @ordered
	 */
	protected boolean depthWrite = DEPTH_WRITE_EDEFAULT;

	/**
	 * The default value of the '{@link #isDepthBoundTest() <em>Depth Bound Test</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDepthBoundTest()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEPTH_BOUND_TEST_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isDepthBoundTest() <em>Depth Bound Test</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDepthBoundTest()
	 * @generated
	 * @ordered
	 */
	protected boolean depthBoundTest = DEPTH_BOUND_TEST_EDEFAULT;

	/**
	 * The default value of the '{@link #isStencilTest() <em>Stencil Test</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStencilTest()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STENCIL_TEST_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStencilTest() <em>Stencil Test</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStencilTest()
	 * @generated
	 * @ordered
	 */
	protected boolean stencilTest = STENCIL_TEST_EDEFAULT;

	/**
	 * The default value of the '{@link #getDepthCompareOp() <em>Depth Compare Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepthCompareOp()
	 * @generated
	 * @ordered
	 */
	protected static final ECompareOp DEPTH_COMPARE_OP_EDEFAULT = ECompareOp.LESS;

	/**
	 * The cached value of the '{@link #getDepthCompareOp() <em>Depth Compare Op</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDepthCompareOp()
	 * @generated
	 * @ordered
	 */
	protected ECompareOp depthCompareOp = DEPTH_COMPARE_OP_EDEFAULT;

	/**
	 * The default value of the '{@link #getMinDepthBounds() <em>Min Depth Bounds</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinDepthBounds()
	 * @generated
	 * @ordered
	 */
	protected static final float MIN_DEPTH_BOUNDS_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getMinDepthBounds() <em>Min Depth Bounds</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMinDepthBounds()
	 * @generated
	 * @ordered
	 */
	protected float minDepthBounds = MIN_DEPTH_BOUNDS_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxDepthBounds() <em>Max Depth Bounds</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxDepthBounds()
	 * @generated
	 * @ordered
	 */
	protected static final float MAX_DEPTH_BOUNDS_EDEFAULT = 1.0F;

	/**
	 * The cached value of the '{@link #getMaxDepthBounds() <em>Max Depth Bounds</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxDepthBounds()
	 * @generated
	 * @ordered
	 */
	protected float maxDepthBounds = MAX_DEPTH_BOUNDS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DepthStencilStateImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return GraphicpipelinePackage.Literals.DEPTH_STENCIL_STATE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDepthTest()
	{
		return depthTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepthTest(boolean newDepthTest)
	{
		boolean oldDepthTest = depthTest;
		depthTest = newDepthTest;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.DEPTH_STENCIL_STATE__DEPTH_TEST, oldDepthTest, depthTest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDepthWrite()
	{
		return depthWrite;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepthWrite(boolean newDepthWrite)
	{
		boolean oldDepthWrite = depthWrite;
		depthWrite = newDepthWrite;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.DEPTH_STENCIL_STATE__DEPTH_WRITE, oldDepthWrite, depthWrite));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDepthBoundTest()
	{
		return depthBoundTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepthBoundTest(boolean newDepthBoundTest)
	{
		boolean oldDepthBoundTest = depthBoundTest;
		depthBoundTest = newDepthBoundTest;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.DEPTH_STENCIL_STATE__DEPTH_BOUND_TEST, oldDepthBoundTest, depthBoundTest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isStencilTest()
	{
		return stencilTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStencilTest(boolean newStencilTest)
	{
		boolean oldStencilTest = stencilTest;
		stencilTest = newStencilTest;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.DEPTH_STENCIL_STATE__STENCIL_TEST, oldStencilTest, stencilTest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ECompareOp getDepthCompareOp()
	{
		return depthCompareOp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDepthCompareOp(ECompareOp newDepthCompareOp)
	{
		ECompareOp oldDepthCompareOp = depthCompareOp;
		depthCompareOp = newDepthCompareOp == null ? DEPTH_COMPARE_OP_EDEFAULT : newDepthCompareOp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.DEPTH_STENCIL_STATE__DEPTH_COMPARE_OP, oldDepthCompareOp, depthCompareOp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getMinDepthBounds()
	{
		return minDepthBounds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMinDepthBounds(float newMinDepthBounds)
	{
		float oldMinDepthBounds = minDepthBounds;
		minDepthBounds = newMinDepthBounds;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.DEPTH_STENCIL_STATE__MIN_DEPTH_BOUNDS, oldMinDepthBounds, minDepthBounds));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getMaxDepthBounds()
	{
		return maxDepthBounds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMaxDepthBounds(float newMaxDepthBounds)
	{
		float oldMaxDepthBounds = maxDepthBounds;
		maxDepthBounds = newMaxDepthBounds;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, GraphicpipelinePackage.DEPTH_STENCIL_STATE__MAX_DEPTH_BOUNDS, oldMaxDepthBounds, maxDepthBounds));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__DEPTH_TEST:
				return isDepthTest();
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__DEPTH_WRITE:
				return isDepthWrite();
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__DEPTH_BOUND_TEST:
				return isDepthBoundTest();
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__STENCIL_TEST:
				return isStencilTest();
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__DEPTH_COMPARE_OP:
				return getDepthCompareOp();
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__MIN_DEPTH_BOUNDS:
				return getMinDepthBounds();
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__MAX_DEPTH_BOUNDS:
				return getMaxDepthBounds();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID)
		{
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__DEPTH_TEST:
				setDepthTest((Boolean)newValue);
				return;
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__DEPTH_WRITE:
				setDepthWrite((Boolean)newValue);
				return;
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__DEPTH_BOUND_TEST:
				setDepthBoundTest((Boolean)newValue);
				return;
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__STENCIL_TEST:
				setStencilTest((Boolean)newValue);
				return;
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__DEPTH_COMPARE_OP:
				setDepthCompareOp((ECompareOp)newValue);
				return;
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__MIN_DEPTH_BOUNDS:
				setMinDepthBounds((Float)newValue);
				return;
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__MAX_DEPTH_BOUNDS:
				setMaxDepthBounds((Float)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID)
		{
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__DEPTH_TEST:
				setDepthTest(DEPTH_TEST_EDEFAULT);
				return;
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__DEPTH_WRITE:
				setDepthWrite(DEPTH_WRITE_EDEFAULT);
				return;
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__DEPTH_BOUND_TEST:
				setDepthBoundTest(DEPTH_BOUND_TEST_EDEFAULT);
				return;
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__STENCIL_TEST:
				setStencilTest(STENCIL_TEST_EDEFAULT);
				return;
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__DEPTH_COMPARE_OP:
				setDepthCompareOp(DEPTH_COMPARE_OP_EDEFAULT);
				return;
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__MIN_DEPTH_BOUNDS:
				setMinDepthBounds(MIN_DEPTH_BOUNDS_EDEFAULT);
				return;
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__MAX_DEPTH_BOUNDS:
				setMaxDepthBounds(MAX_DEPTH_BOUNDS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID)
		{
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__DEPTH_TEST:
				return depthTest != DEPTH_TEST_EDEFAULT;
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__DEPTH_WRITE:
				return depthWrite != DEPTH_WRITE_EDEFAULT;
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__DEPTH_BOUND_TEST:
				return depthBoundTest != DEPTH_BOUND_TEST_EDEFAULT;
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__STENCIL_TEST:
				return stencilTest != STENCIL_TEST_EDEFAULT;
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__DEPTH_COMPARE_OP:
				return depthCompareOp != DEPTH_COMPARE_OP_EDEFAULT;
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__MIN_DEPTH_BOUNDS:
				return minDepthBounds != MIN_DEPTH_BOUNDS_EDEFAULT;
			case GraphicpipelinePackage.DEPTH_STENCIL_STATE__MAX_DEPTH_BOUNDS:
				return maxDepthBounds != MAX_DEPTH_BOUNDS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString()
	{
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (depthTest: ");
		result.append(depthTest);
		result.append(", depthWrite: ");
		result.append(depthWrite);
		result.append(", depthBoundTest: ");
		result.append(depthBoundTest);
		result.append(", stencilTest: ");
		result.append(stencilTest);
		result.append(", depthCompareOp: ");
		result.append(depthCompareOp);
		result.append(", minDepthBounds: ");
		result.append(minDepthBounds);
		result.append(", maxDepthBounds: ");
		result.append(maxDepthBounds);
		result.append(')');
		return result.toString();
	}

} //DepthStencilStateImpl
